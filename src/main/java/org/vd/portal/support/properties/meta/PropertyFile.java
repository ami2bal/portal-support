package org.vd.portal.support.properties.meta;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation à poser sur l'enum mappant un fichier de propriété
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PropertyFile {

    /**
     * Nom du fichier de propriété : inutile de spécifier l'extension .properties
     * Ex: pour default.properties @PropertyFile("default")
     */
    String value();
}
