package org.vd.portal.support.properties.file;

import org.vd.portal.support.properties.PropertiesUtils;
import org.vd.portal.support.properties.meta.PropertyFile;
import org.vd.portal.support.properties.meta.PropertyStructure;

import static org.vd.portal.support.properties.meta.PropertyStructure.Type.*;

/**
 * Properties du fichier de configuration du web service IPS
 */
@PropertyFile("config/siteminder")
public enum SiteMinderProperties implements PropertyStructure {

    SITEMINDER_HEADER_EMAIL("siteminder.header.email", STRING),
    SITEMINDER_HEADER_FIRSTNAME("siteminder.header.firstname", STRING),
    SITEMINDER_HEADER_LASTNAME("siteminder.header.lastname", STRING),
    SITEMINDER_HEADER_ROLES("siteminder.header.roles", STRING),
    SITEMINDER_HEADER_GENDER("siteminder.header.gender", STRING),
    SITEMINDER_HEADER_VALUES_SEPARATOR("siteminder.header.values.separator", STRING),
    SITEMINDER_SESSION_COOKIE("siteminder.session.cookie", STRING),
    SITEMINDER_IMPORT_FROM_HEADERS("siteminder.import.from.headers", BOOLEAN),
    SITEMINDER_ROLES_SEPARATORS("siteminder.roles.separators", STRING),
    SITEMINDER_ROLE_ADMINISTRATOR("siteminder.role.administrator", STRING),
    SITEMINDER_ROLES_IGNORE("siteminder.roles.ignore", ARRAY);

    private String key;

    private Type type;

    /**
     * Constructeur
     *
     * @param key
     * @param type
     */
    private SiteMinderProperties(String key, Type type) {
        this.key = key;
        this.type = type;
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
}
