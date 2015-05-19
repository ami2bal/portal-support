package org.vd.portal.support.tools.utils;

/**
 * Created by vav6wy on 22/07/14.
 */
public class StringUtils {

    /**
     * Retourne la chaîne de caractère comme chaîne vide, si celle-ci est nulle ou non renseignée
     *
     * @param value
     * @return
     */
    public static String emptyString(String value) {
        if (null == value || value.trim().length() == 0) {
            return "";
        }
        return value;
    }

    /**
     * Retourne l'objet comme chaîne vide, si celle-ci est nulle ou non renseignée
     *
     * @param object
     * @return
     */
    public static String emptyObject(Object object) {
        if (null == object) return "";
        return emptyString(object.toString());
    }
}
