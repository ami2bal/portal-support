package org.vd.portal.support.properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.vd.portal.support.properties.file.SiteMinderProperties;
import org.vd.portal.support.properties.file.ws.IpsProperties;
import org.vd.portal.support.properties.file.ws.UserProperties;
import org.vd.portal.support.properties.meta.PropertyFile;
import org.vd.portal.support.properties.meta.PropertyStructure;
import org.vd.portal.support.tools.file.FileUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Gestionnaire de properties de configuration (non localisés) */
public class PropertiesUtils {

    /** Suffixe de fichier properties */
    private static final String PROPERTIES_SUFFIX = ".properties";
    /** Classes de mapping des fichiers properties */
    private static final List<? extends Class<? extends PropertyStructure>> PROPERTIES_CLASS = Arrays.asList(
            IpsProperties.class,
            SiteMinderProperties.class,
            UserProperties.class);
    /** Log class */
    private final static Log _log = LogFactoryImpl.getLog(PropertiesUtils.class);
    /** Singleton */
    private final static PropertiesUtils instance = new PropertiesUtils();
    /** Map des properties par fichier de configuration */
    private Map<Class<? extends PropertyStructure>, Properties> propertiesByMappedEnum = new HashMap<Class<? extends PropertyStructure>, Properties>();

    /** Constructeur */
    private PropertiesUtils() {

        loadConfiguration();
    }

    /**
     * Retourne la valeur associée à la clef de propriété passée en argument.
     * La clef elle-même sera retournée en cas d'erreur de chargement
     *
     * @param propertyStructure
     *
     * @return
     */
    public static String getStringValue(PropertyStructure propertyStructure) {

        //Extraction de la valeur
        String value = instance.extractStringValue(propertyStructure);

        return value;
    }

    /**
     * Retourne la valeur associée à la clef de propriété passée en argument.
     * La clef elle-même sera retournée en cas d'erreur de chargement
     *
     * @param propertyStructure
     *
     * @return
     */
    public static Integer getIntegerValue(PropertyStructure propertyStructure) {

        //Extraction de la valeur
        String value = instance.extractStringValue(propertyStructure);
        if (null == value) return null;

        return Integer.parseInt(value);
    }

    /**
     * Retourne la valeur associée à la clef de propriété passée en argument.
     * La clef elle-même sera retournée en cas d'erreur de chargement
     *
     * @param propertyStructure
     *
     * @return
     */
    public static Boolean getBooleanValue(PropertyStructure propertyStructure) {

        //Extraction de la valeur
        String value = instance.extractStringValue(propertyStructure);
        if (null == value) return false;

        String regexPattern = "^(0|1|true|false)$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    /**
     * Retourne la valeur associée à la clef de propriété passée en argument.
     * La clef elle-même sera retournée en cas d'erreur de chargement
     *
     * @param propertyStructure
     *
     * @return
     */
    public static String[] getArrayValue(PropertyStructure propertyStructure) {

        //Extraction de la valeur
        String value = instance.extractStringValue(propertyStructure);
        if (null == value) return null;

        StringTokenizer stringTokenizer = new StringTokenizer(value, ",");
        int nbTokens = stringTokenizer.countTokens();
        String[] arrayValue = new String[nbTokens];
        for (int i = 0; i < nbTokens; i++) {
            arrayValue[i] = stringTokenizer.nextToken();
        }

        return arrayValue;
    }

    /** Charge/Re-charge les fichiers de paramétrage en mémoire. */
    public void loadConfiguration() {

        //Purge la map des fichiers de properties
        propertiesByMappedEnum.clear();

        //Collecte les fichiers de configuration
        List<? extends Class<? extends PropertyStructure>> propertiesFileStructures = PROPERTIES_CLASS;

        //Collecte les fichiers détectés dans le classloader applicatif
        /*List<? extends Class<? extends PropertyStructure>> propertiesFileStructuresDetected = ReflectionUtils.getInstance().getClassesByImplement(PropertyStructure.class);
        for (Class<?> propertiesFileStructureDetected : propertiesFileStructuresDetected) {
            if (!propertiesFileStructures.contains(propertiesFileStructureDetected)) {
                propertiesFileStructures.add(propertiesFileStructureDetected);
                System.out.println(propertiesFileStructureDetected);
            }
        }*/

        //Charge les fichiers de configuration
        for (Class<? extends PropertyStructure> propertiesFileStructure : propertiesFileStructures) {

            //Extrait les métadonnées
            PropertyFile propertyFile = propertiesFileStructure.getAnnotation(PropertyFile.class);

            //Contrôle les métadonnées
            boolean isFileNameValid = isFileNameValid(propertiesFileStructure, propertyFile);

            if (isFileNameValid) { //Chargement du fichier en mémoire
                loadFiles(propertiesFileStructure, propertyFile);
            } else { //Fichier incorrect non chargé
                _log.error("Impossible de charger le fichier de propriété mappé à l'enum [" + propertiesFileStructure.getName() + "]");
            }
        }
    }

    /**
     * Opération de chargement des fichiers après contrôle de la validité des métadonnées
     *
     * @param propertiesFileStructure
     * @param propertyFile
     */
    private void loadFiles(Class<? extends PropertyStructure> propertiesFileStructure, PropertyFile propertyFile) {

        //Charge la configuration du fichier
        FileUtils fileUtils = new FileUtils(true, propertyFile.value() + PROPERTIES_SUFFIX);
        InputStream inputStream = fileUtils.getInputStream();

        if (null == inputStream) { //Echec du chargement
            _log.error("Le fichier de properties [" + propertyFile.value() + "] de la classe [" + propertiesFileStructure.getName() + "] n'a pas pu être chargé");
        } else {
            Properties properties = new Properties();
            try {
                properties.load(inputStream);
                inputStream.close();

            } catch (IOException e) {
                _log.error("Le fichier de properties [" + propertyFile.value() + "] de la classe [" + propertiesFileStructure.getName() + "] a rencontré un problème de chargement", e);
            }

            //Contrôle le mapping des propriétés enum/properties
            checkPropertyMapping(propertiesFileStructure, propertyFile, properties);

            //Charge les données du fichier dans une map en mémoire
            propertiesByMappedEnum.put(propertiesFileStructure, properties);
        }
    }

    /**
     * Contrôle le mapping entre l'enum et son fichier de propriété. Trace une erreur si une clef définie dans une enum
     * n'a pas d'entrée correspondante dans son fichier de properties. Ce contrôle n'est pas bloquant.
     *
     * @param propertiesFileStructure
     * @param propertyFile
     * @param properties
     */
    private void checkPropertyMapping(Class<? extends PropertyStructure> propertiesFileStructure, PropertyFile propertyFile, Properties properties) {

        //Collecte les clefs de propriété à partir des enums
        PropertyStructure[] propertyStructures = propertiesFileStructure.getEnumConstants();

        for (PropertyStructure propertyStructure : propertyStructures) {

            //Extrait la clef de propriété du properties à partir de l'enum de correspondance
            String propertyValue = properties.getProperty(propertyStructure.getKey());

            //Contrôle l'existence de la propriété
            if (null == propertyValue) {
                _log.error("La clef de propriété [" + propertyStructure.getKey() + "] de la classe [" + propertiesFileStructure.getName() + "] n'est pas définie dans son fichier de properties [" + propertyFile.value() + PROPERTIES_SUFFIX + "]");
            } else {//Contrôle le type de la donnée

                checkPropertyDataType(propertiesFileStructure, propertyStructure, propertyValue);
            }
        }
    }

    /**
     * Contrôle que la validité du type de donnée est respectée
     *
     * @param propertiesFileStructure
     * @param propertyStructure
     * @param propertyValue
     */
    private void checkPropertyDataType(Class<? extends PropertyStructure> propertiesFileStructure, PropertyStructure propertyStructure, String propertyValue) {
        String regexPattern = null;

        //Récupération du pattern de contrôle en lien avec le type de données
        if (Integer.class.equals(propertyStructure.getType().javaClass)) {
            regexPattern = "^\\d*$";
        } else if (Boolean.class.equals(propertyStructure.getType().javaClass)) {
            regexPattern = "^(0|1|true|false)$";
        }

        //Exécution du contrôle
        if (null != regexPattern) {
            Pattern pattern = Pattern.compile(regexPattern);
            Matcher matcher = pattern.matcher(propertyValue);
            if (!matcher.matches()) {
                _log.error("La clef de propriété [" + propertyStructure.getKey() + "] de la classe [" + propertiesFileStructure.getName() + "] est indiquée avoir le type [" + propertyStructure.getType() + "] alors qu'elle a pour valeur : " + propertyValue);
            }
        }
    }

    /**
     * Contrôle que le fichier de propriété est correctement mappé avec son enum de correspondance
     *
     * @param propertiesFileStructure
     * @param propertyFile
     *
     * @throws Exception
     */
    private boolean isFileNameValid(Class<? extends PropertyStructure> propertiesFileStructure, PropertyFile propertyFile) {

        //Contrôle la présence de l'annotation du nom de fichier
        if (null == propertyFile) {
            _log.error("L'annotation PropertyFile doit être apposée sur la classe [" + propertiesFileStructure.getName() + "]");
            return false;
        }

        //Contrôle que l'annotation est renseignée
        if (null == propertyFile.value() || propertyFile.value().trim().isEmpty()) {
            _log.error("L'annotation PropertyFile de la classe [" + propertiesFileStructure.getName() + "] ne contient pas de nom de fichier");
            return false;
        }

        return true;
    }

    /**
     * Retourne la valeur associée à la clef de propriété au format String.
     * La clef elle-même sera retournée en cas d'erreur de chargement
     *
     * @param propertyStructure
     *
     * @return
     */

    private String extractStringValue(PropertyStructure propertyStructure) {

        //Contrôle que la property passée en argument n'est pas nulle
        if (null == propertyStructure) {
            _log.error("La clef de propriété demandée ne peut être null");
            return "[AUCUNE_CLEF_DEFINIE]";
        }

        //Extraction de la valeur de la propriété
        Properties properties = propertiesByMappedEnum.get(propertyStructure.getClass());

        //Contrôle que le fichier a été correctement chargé
        if (null == properties) {
            _log.error("Le fichier de propriété correspondant à la classe [" + propertyStructure.getClass() + "] n'a pas été correctement chargé");
            return "[" + propertyStructure.getKey() + "]";
        }

        return properties.getProperty(propertyStructure.getKey());
    }
}
