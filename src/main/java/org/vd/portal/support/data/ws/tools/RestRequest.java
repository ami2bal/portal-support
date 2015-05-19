package org.vd.portal.support.data.ws.tools;

import java.util.HashMap;
import java.util.Map;


public class RestRequest {

    /** Type de methode http utilisée (Post/Get exclusivement) */
    private String requestMethod;
    /** Url de la requête */
    private String url;
    /** Accès authentifié */
    private boolean doAuthentication;
    /** Paramètres Rest */
    private Map<String, String> parametersMap;
    /** Paramètres du header Http */
    private Map<String, String> headersMap;

    /** Constructeur */
    public RestRequest() {
        parametersMap = new HashMap<String, String>();
        headersMap = new HashMap<String, String>();
    }

    public Map<String, String> getHeadersMap() {
        return headersMap;
    }

    public void setHeadersMap(Map<String, String> headersMap) {
        this.headersMap = headersMap;
    }

    public Map<String, String> getParametersMap() {
        return parametersMap;
    }

    public void setParametersMap(Map<String, String> parametersMap) {
        this.parametersMap = parametersMap;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isDoAuthentication() {
        return doAuthentication;
    }

    public void setDoAuthentication(boolean doAuthentication) {
        this.doAuthentication = doAuthentication;
    }


}
