package org.vd.portal.support.tools.reflection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/** Manager de classes */
public class ReflectionUtils {

    /** Packages à charger */
    private final static String PACKAGE_ROOT = "org.vd.portal";
    /** Extension de classe compilée */
    private final static String CLASS_EXTENSION = ".class";
    /** Logger */
    private final static Log _log = LogFactoryImpl.getLog(ReflectionUtils.class);
    /** Singleton */
    private static ReflectionUtils instance = new ReflectionUtils();
    /** Collecte les classes chargées en mémoire */
    private List<Class> classes = new ArrayList<>();

    /** Constructeur */
    private ReflectionUtils() {

        //Charge les classes en mémoire
        loadClasses();
    }

    /**
     * Retourne l'instance courante
     *
     * @return
     */
    public static ReflectionUtils getInstance() {
        return instance;
    }

    /** Charge les classes en mémoire */
    private void loadClasses() {

        //Réinitialise le contenu des classes en mémoire
        classes = new ArrayList<>();

        //Collecte les classes chargées depuis le file system
        classes = getClasses(PACKAGE_ROOT, true);

        //Parcourt les packages chargés par le classloader
        Package[] packages = Package.getPackages();
        for (Package aPackage : packages) {

            //Charge les package
            String packageName = aPackage.getName();

            if (packageName.contains("properties.file.config")) {
                System.out.println(packageName);
            }

            if (packageName.startsWith(PACKAGE_ROOT)) {

                //Récupère les classes par package
                classes.addAll(getClasses(packageName, false));
            }
        }
    }

    /**
     * Extraction des classes par nom de package depuis le classloader
     *
     * @param packageName    : nom du package (ex: "org.vd.portal")
     * @param allowRecursive : Autorise l'analyse récursive des packages
     *
     * @return
     */
    private List<Class> getClasses(String packageName, boolean allowRecursive) {

        //Classes
        ArrayList<Class> classes = new ArrayList<>();


        //Class loader courant
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        //Répertoire correspondant au package
        String path = packageName.replace('.', '/');
        URL resource = classLoader.getResource(path);
        File directory = new File(resource.getFile());

        //Récupération des classes
        if (directory.exists()) {

            //Récupère la liste des fichiers du répertoire
            String[] directoryContent = directory.list();
            for (int i = 0; i < directoryContent.length; i++) {

                String resourceInDirectory = directoryContent[i];
                if (!resourceInDirectory.contains("$")) {

                    String className;

                    //Détection de classes dans le package
                    if (resourceInDirectory.endsWith(CLASS_EXTENSION)) {

                        //Longueur de la chaîne de caractère correspondant à la classe, sans extension ex: MyClass
                        int lengthClassName = resourceInDirectory.length() - CLASS_EXTENSION.length();
                        className = packageName + '.' + resourceInDirectory.substring(0, lengthClassName);

                        //Conversion de la resource en classe
                        try {
                            //Chargement de la classe et ajout en mémoire
                            Class aClass = Class.forName(className);
                            if (null != aClass) {
                                classes.add(aClass);
                            }
                        } catch (Exception e) {
                            _log.error("Impossible de charger la classe [" + className + "]", e);
                        }
                    } else if (allowRecursive && !resourceInDirectory.contains(".")) { //Détection d'un folder

                        //Chargement des classes et ajout en mémoire
                        className = packageName + "." + resourceInDirectory;
                        List<Class> additionnalClasses = getClasses(className, allowRecursive);
                        for (Class additionnalClass : additionnalClasses) {
                            if (!classes.contains(additionnalClass)) {
                                classes.add(additionnalClass);
                            }
                        }
                    }
                }
            }
        }


        return classes;
    }

    /**
     * Parcourt les classes du projet annotées avec l'interface donnée
     *
     * @param annotation : annotation à rechercher dans les classes du projet
     *
     * @return
     */
    public <T> List<Class<? extends T>> getClassesByAnnotation(Class<? extends T> annotation) {

        List<Class<? extends T>> classesAnnotated = new ArrayList<>();
        for (Class aClass : classes) {
            if (aClass.isAnnotationPresent(annotation)) {
                classesAnnotated.add(aClass);
            }
        }

        return classesAnnotated;
    }

    /**
     * Parcourt les classes du projet qui étendent la classe donnée
     *
     * @param extendClass : classes qui étendent la classe donnée
     *
     * @return
     */
    public <T> List<Class<? extends T>> getClassesByExtend(Class<T> extendClass) {

        List<Class<? extends T>> classesAnnotated = new ArrayList<>();
        for (Class aClass : classes) {
            if (aClass.isAssignableFrom(extendClass)) {
                classesAnnotated.add(aClass);
            }
        }

        return classesAnnotated;
    }

    /**
     * Parcourt les classes du projet qui implémentent la classe donnée
     *
     * @param implementClass : classes qui implémentent la classe donnée
     *
     * @return
     */
    public <T> List<Class<? extends T>> getClassesByImplement(Class<T> implementClass) {

        return getClassesByExtend(implementClass);
    }
}
