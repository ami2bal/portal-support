package org.vd.portal.support.properties.meta;

import java.lang.reflect.Array;

/**
 * Structure des enums mappant les fichiers de config de type properties
 */
public interface PropertyStructure {

    /**
     * Retourne la clef de propriété associée à la clef de property
     *
     * @return
     */
    public String getKey();

    /**
     * Retourne le type de la propriété
     *
     * @return
     */
    public Type getType();

    /**
     * Retourne la valeur au format String
     * @return
     */
    public String value();

    /**
     * Retourne la valeur au format String
     * @return
     */
    public Integer intValue();

    /**
     * Retourne la valeur au format String
     * @return
     */
    public Boolean boolValue();

    /**
     * Retourne la valeur au format String
     * @return
     */
    public String[] arrayValue();

    public enum Type {
        STRING(String.class),
        INT(Integer.class),
        BOOLEAN(Boolean.class),
        ARRAY(Array.class);

        public Class<?> javaClass;

        /**
         * Constructeur
         *
         * @param javaClass
         */
        private Type(Class<?> javaClass) {
            this.javaClass = javaClass;
        }
    }
}
