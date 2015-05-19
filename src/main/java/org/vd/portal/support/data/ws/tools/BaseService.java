package org.vd.portal.support.data.ws.tools;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthPolicy;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.io.IOUtils;
import org.vd.portal.data.ws.rest.client.model.ErrorWs;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.ArrayList;
import java.util.List;


/** Gestionnaire de base de client WS REST */
public class BaseService {

    /** Client http */
    protected HttpClient client;
    /** Login de connexion */
    protected String userName;
    /** Password de connexion */
    protected String password;
    /** URI de connexion */
    protected String serviceBaseUrl;
    /** Connexion sécurisée */
    protected String authMode;

    /**
     * Constructeur
     *
     * @param serviceBaseUrl
     * @param userName
     * @param password
     * @param authMode
     */
    public BaseService(String serviceBaseUrl, String userName, String password, String authMode) {

        this.serviceBaseUrl = serviceBaseUrl;
        this.userName = userName;
        this.password = password;
        this.authMode = authMode;

        client = new HttpClient();

        if (authMode != null && authMode.equals("basic")) {

            List<String> authPrefs = new ArrayList<String>(1);
            authPrefs.add(AuthPolicy.BASIC);
            client.getParams().setParameter(AuthPolicy.AUTH_SCHEME_PRIORITY, authPrefs);
            client.getParams().setAuthenticationPreemptive(true);

            Credentials credentials = new UsernamePasswordCredentials(userName, password);
            client.getState().setCredentials(new AuthScope(serviceBaseUrl, 80, AuthScope.ANY_REALM), credentials);

        }

    }

    public void processHttpStatusCode(RestResponse restResponse) throws PrestationsWsException {

        if (restResponse.getStatusCode() == 200) {
            return;
        } else {
            try {
                JAXBContext jc = JAXBContext.newInstance(ErrorWs.class);

                Unmarshaller unmarshaller = jc.createUnmarshaller();
                Object object = (Object) unmarshaller.unmarshal(IOUtils.toInputStream(restResponse.getResponse()));

                if (object instanceof ErrorWs) {
                    ErrorWs errorWs = (ErrorWs) object;

                    throw new PrestationsWsException(errorWs.getMessage(), restResponse.getStatusCode());
                } else {

                }
            } catch (JAXBException e) {
                throw new PrestationsWsException(e);
            }
        }
    }

    public String getServiceBaseUrl() {
        return serviceBaseUrl;
    }

    public void setServiceBaseUrl(String serviceBaseUrl) {
        this.serviceBaseUrl = serviceBaseUrl;
    }

    public HttpClient getClient() {
        return client;
    }

    public void setClient(HttpClient client) {
        this.client = client;
    }


}
