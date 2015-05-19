package org.vd.portal.support.properties.file.ws;

import org.vd.portal.support.properties.PropertiesUtils;
import org.vd.portal.support.properties.meta.PropertyFile;
import org.vd.portal.support.properties.meta.PropertyStructure;

import static org.vd.portal.support.properties.meta.PropertyStructure.Type.*;

/** Properties du fichier de configuration du client de Mailing */
@PropertyFile("ws/webservice_user")
public enum UserProperties implements PropertyStructure {

    USER_URL("ws.user.url", STRING),
    USER_USERNAME("ws.user.username", STRING),
    USER_PASSWORD("ws.user.password", STRING),
    USER_AUTHENTIFICATION("ws.user.authentification", STRING);
    private String key;
    private Type type;

    /**
     * Constructeur
     *
     * @param key
     * @param type
     */
    private UserProperties(String key, Type type) {
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
