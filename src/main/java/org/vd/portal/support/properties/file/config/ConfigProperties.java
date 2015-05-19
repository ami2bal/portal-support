package org.vd.portal.support.properties.file.config;

import org.vd.portal.support.properties.PropertiesUtils;
import org.vd.portal.support.properties.meta.PropertyFile;
import org.vd.portal.support.properties.meta.PropertyStructure;

import static org.vd.portal.support.properties.meta.PropertyStructure.Type.*;

/** Properties du fichier de configuration du client de Mailing */
@PropertyFile("config/config-core")
public enum ConfigProperties implements PropertyStructure {

    ENVIRONNEMENT("portal.env", STRING),

    //Site accueil
    SITE_ACCUEIL_PROTOCOL("portal.accueil.protocol", STRING),
    SITE_ACCUEIL_HOST("portal.accueil.host", STRING),
    SITE_ACCUEIL_PORT("portal.accueil.port", STRING),
    SITE_ACCUEIL_CONTEXT("portal.accueil.context", STRING),
    SITE_ACCUEIL_COMPLETE_URL("portal.accueil.complete-url", STRING),

    //Site particuliers
    SITE_PARTICULIERS_PROTOCOL("portal.particuliers.protocol", STRING),
    SITE_PARTICULIERS_HOST("portal.particuliers.host", STRING),
    SITE_PARTICULIERS_PORT("portal.particuliers.port", STRING),
    SITE_PARTICULIERS_CONTEXT("portal.particuliers.context", STRING),
    SITE_PARTICULIERS_COMPLETE_URL("portal.particuliers.complete-url", STRING),

    //Site communes
    SITE_COMMUNES_PROTOCOL("portal.communes.protocol", STRING),
    SITE_COMMUNES_HOST("portal.communes.host", STRING),
    SITE_COMMUNES_PORT("portal.communes.port", STRING),
    SITE_COMMUNES_CONTEXT("portal.communes.context", STRING),
    SITE_COMMUNES_COMPLETE_URL("portal.communes.complete-url", STRING),

    //Site entreprises
    SITE_ENTREPRISES_PROTOCOL("portal.entreprises.protocol", STRING),
    SITE_ENTREPRISES_HOST("portal.entreprises.host", STRING),
    SITE_ENTREPRISES_PORT("portal.entreprises.port", STRING),
    SITE_ENTREPRISES_CONTEXT("portal.entreprises.context", STRING),
    SITE_ENTREPRISES_COMPLETE_URL("portal.entreprises.complete-url", STRING),

    //Site partenaires
    SITE_PARTENAIRES_PROTOCOL("portal.partenaires.protocol", STRING),
    SITE_PARTENAIRES_HOST("portal.partenaires.host", STRING),
    SITE_PARTENAIRES_PORT("portal.partenaires.port", STRING),
    SITE_PARTENAIRES_CONTEXT("portal.partenaires.context", STRING),
    SITE_PARTENAIRES_COMPLETE_URL("portal.partenaires.complete-url", STRING),;
    private String key;
    private Type type;

    /**
     * Constructeur
     *
     * @param key
     * @param type
     */
    private ConfigProperties(String key, Type type) {
        this.key = key;
        this.type = type;
    }

    /**
     * Retourne l'environnement courant
     *
     * @return
     */
    public static ENV getEnvironnement() {
        return ENV.getENVByValue(ENVIRONNEMENT.value());
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String value() {
        return PropertiesUtils.getStringValue(this);
    }

    @Override
    public Integer intValue() {
        return PropertiesUtils.getIntegerValue(this);
    }

    @Override
    public Boolean boolValue() {
        return PropertiesUtils.getBooleanValue(this);
    }

    @Override
    public String[] arrayValue() {
        return PropertiesUtils.getArrayValue(this);
    }

    /** Types d'environnement disponibles */
    public enum ENV {
        DEV("dev");
        public String value;

        /**
         * Constructeur
         *
         * @param value
         */
        private ENV(String value) {
            this.value = value;
        }

        /**
         * Retourne l'environnement associé à la valeur donnée
         * ou null si aucun environnement correspondant
         *
         * @param value
         *
         * @return
         */
        public static ENV getENVByValue(String value) {
            for (ENV env : ENV.values()) {
                if (env.value.equalsIgnoreCase(value)) {
                    return env;
                }
            }
            return null;
        }
    }
}
