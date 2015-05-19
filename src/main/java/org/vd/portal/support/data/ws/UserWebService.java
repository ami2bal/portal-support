package org.vd.portal.support.data.ws;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.vd.portal.data.ws.rest.client.model.ErrorWs;
import org.vd.portal.data.ws.rest.client.model.UserWs;
import org.vd.portal.support.data.ws.tools.*;
import org.vd.portal.support.properties.file.ws.UserProperties;

import javax.ws.rs.HttpMethod;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.URI;
import java.nio.charset.Charset;

/** Gestionnaire du web service utilisateur */
public class UserWebService extends BaseService {

    /** Nom du service */
    public static final String SERVICE_PATH = "user";
    /** Logger */
    private final static Log _log = LogFactoryImpl.getLog(UserWebService.class);
    /** Url du webservice de messagerie */
    private static String WS_URL = UserProperties.USER_URL.value();
    /** Username de connexion au web service */
    private static String WS_USERNAME = UserProperties.USER_USERNAME.value();
    /** Password  pour la connexion au web service */
    private static String WS_PASSWORD = UserProperties.USER_PASSWORD.value();
    /** Authentification  pour la connexion au web service */
    private static String WS_AUTH = UserProperties.USER_AUTHENTIFICATION.value();

    /** Constructeur */
    public UserWebService() {
        super(WS_URL, WS_USERNAME, WS_PASSWORD, WS_AUTH);
    }

    /**
     * Retourne l'utilisateur associé au login
     *
     * @param login
     *
     * @return
     *
     */
    public UserWs getUserByLogin(String login) throws PrestationsWsException {

        UserWs userWs;

        RestRequest restRequest = new RestRequest();

        restRequest.setRequestMethod(HttpMethod.GET);

        URI uri = URI.create(serviceBaseUrl + SERVICE_PATH + "/getbylogin/login/"+login);

        restRequest.setUrl(uri.toString());

        //Paramètres du header
        restRequest.getHeadersMap().put("iam-userid", userName);
        restRequest.getHeadersMap().put("Content-Type",
                "application/x-www-form-urlencoded; " +
                        "charset=" + Charset.defaultCharset().toString());

        //Exécution de la requête
        RestResponse response = RestUtil.executeMethod(client, restRequest);

        //Conversion du résultat
        userWs = toUserWs(response);

        return userWs;

    }

    /**
     * Convertit la réponse du web service en objet utilisateur
     *
     * @param response
     *
     * @return
     *
     * @throws PrestationsWsException
     */
    private UserWs toUserWs(RestResponse response) throws PrestationsWsException {

        try {
            JAXBContext jc = JAXBContext.newInstance(UserWs.class, ErrorWs.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Object object = (Object) unmarshaller.unmarshal(IOUtils.toInputStream(response.getResponse()));

            if (object instanceof UserWs) {
                UserWs userWs = (UserWs) object;

                _log.info(userWs.getUserId());

                return userWs;
            } else if (object instanceof ErrorWs) {
                ErrorWs errorWs = (ErrorWs) object;

                throw new PrestationsWsException(errorWs.getMessage(), response.getStatusCode());
            } else {
                throw new PrestationsWsException(response.getResponse(), response.getStatusCode());
            }
        } catch (JAXBException e) {
            throw new PrestationsWsException(e);
        }
    }

}
