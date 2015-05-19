package org.vd.portal.support.tools.file;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

/** Gestionnaire de fichiers */
public class FileUtils {

    /** Log class */
    private final static Log _log = LogFactoryImpl.getLog(FileUtils.class);
    /** Informe si le fichier est contenu dans le class loader ou non */
    private boolean inClassLoader;
    /** nom du fichier */
    private String fileName;

    /**
     * Constructeur
     *
     * @param inClassLoader : définit la méthode de chargement du fichier
     * @param fileName      : le file name inclut son chemin d'accès (si non inclus dans le class loader)
     */
    public FileUtils(boolean inClassLoader, String fileName) {
        this.inClassLoader = inClassLoader;
        this.fileName = fileName;
    }

    /**
     * Charge le fichier donné. Attention, il est indispensable de procéder à un "close" une fois le flux lu
     *
     * @return Retourne le fichier chargé, null en cas d'échec
     *
     * @throws Exception
     */
    public InputStream getInputStream() {

        //Contrôle que le nom du fichier est renseigné
        if (null == this.fileName || this.fileName.trim().isEmpty()) {
            _log.error("Le gestionnaire ne peut charger un fichier dont le nom n'est pas renseigné");
            return null;
        }

        //Charge le fichier
        InputStream inputStream = null;
        try {
            if (inClassLoader) {

                //Récupération des entrées correspondantes dans les différents class path
                Enumeration<URL> urls = this.getClass().getClassLoader().getResources(this.fileName);
                while (urls.hasMoreElements()) {
                    URL url = urls.nextElement();
                    inputStream = url.openStream();
                    /*if (url.getPath().contains("/target/")) {
                        inputStream = url.openStream();
                        break;
                    }*/
                }

            } else {
                inputStream = new FileInputStream(this.fileName);
            }
            return inputStream;
        } catch (Exception e) {
            _log.error("Impossible de charger le fichier suivant : " + this.fileName, e);
        }

        return inputStream;
    }
}
