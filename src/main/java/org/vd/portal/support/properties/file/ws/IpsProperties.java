package org.vd.portal.support.properties.file.ws;


import org.vd.portal.support.properties.PropertiesUtils;
import org.vd.portal.support.properties.meta.PropertyFile;
import org.vd.portal.support.properties.meta.PropertyStructure;

import static org.vd.portal.support.properties.meta.PropertyStructure.Type.*;

/**
 * Properties du fichier de configuration du web service IPS
 */
@PropertyFile("ws/webservice_ips")
public enum IpsProperties implements PropertyStructure {

    ENCODING("ws.ips.encoding", STRING),
    BASE_URL("ws.ips.base.url", STRING),
    AUTHENTIFICATION_SCOPE("ws.ips.authscope", STRING),
    AUTHENTIFICATION_ENABLED("ws.ips.auth.enabled", BOOLEAN),
    TIMEOUT_CONNECT("ws.ips.timeout.connect", INT),
    TIMEOUT_REQUEST("ws.ips.timeout.request", INT),
    USERNAME("ws.ips.username", STRING),
    PASSWORD("ws.ips.password", STRING),
    ORGANIZATIONS_LIST("ws.ips.orgas.list", STRING),
    ROLES_LIST("ws.ips.roles.list", STRING),
    ORGANIZATIONS_OFS_PATTERN("ws.ips.org.ofs.pattern", STRING);

    private String key;

    private Type type;

    /**
     * Constructeur
     *
     * @param key
     * @param type
     */
    private IpsProperties(String key, Type type) {
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
