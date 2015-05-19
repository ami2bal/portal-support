package org.vd.portal.support.data.ws;

import ch.vd.registre.evdjaxb.evd_0004._2.ErrorType;
import ch.vd.registre.evdjaxb.evd_0004._2.Errors;
import ch.vd.registre.evdjaxb.refinf.evd_0007._1.ListOfPoliticalEntities;
import ch.vd.registre.evdjaxb.refinf.evd_0007._1.MunicipalityType;
import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthPolicy;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.eclipse.jetty.http.HttpMethods;
import org.vd.portal.support.data.ws.tools.RestRequest;
import org.vd.portal.support.data.ws.tools.RestResponse;
import org.vd.portal.support.data.ws.tools.RestUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RefInfService {

    private static HttpClient client;
    private static String username;
    private static String password;
    private static Log _log = LogFactoryImpl.getLog(RefInfService.class);
    //private final String baseURL;

    /** Constructeur */
    /*public RefInfService() {

        MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
        client = new HttpClient(connectionManager);

        client.getHttpConnectionManager().getParams().setConnectionTimeout(RefInfPropsValues.REFINF_WS_TIMEOUT_CONNECT);
        client.getHttpConnectionManager().getParams().setSoTimeout(RefInfPropsValues.REFINF_WS_TIMEOUT_REQUEST);

        username = RefInfPropsValues.REFINF_WS_USERNAME;
        password = RefInfPropsValues.REFINF_WS_PASSWORD;

        baseURL = RefInfPropsValues.REFINF_WS_BASE_URL;

        List<String> authPrefs = new ArrayList<String>(1);
        authPrefs.add(AuthPolicy.BASIC);
        client.getParams().setParameter(AuthPolicy.AUTH_SCHEME_PRIORITY, authPrefs);

        client.getParams().setAuthenticationPreemptive(true);

        Credentials credentials = new UsernamePasswordCredentials(username, password);
        client.getState().setCredentials(new AuthScope(RefInfPropsValues.REFINF_WS_AUTHSCOPE, 80, AuthScope.ANY_REALM),
                credentials);
    }*/

    /*public List<MunicipalityType> getMunicipalities() throws PortalException {

        List<MunicipalityType> municipalities;

        String url = baseURL + RefInfPropsValues.REFINF_WS_URL_MUNICIPALITIES;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String date = simpleDateFormat.format(new Date());

        url = StringUtils.replace(url, RefInfConstants.REFINF_DATE, date);

        RestRequest wsRequest = new RestRequest();

        wsRequest.setHttpMethod(HttpMethods.GET);

        wsRequest.getHeadersMap().put(ConvercePropsValues.CONVERCE_WS_HEADER_USERID, username);

        wsRequest.getHeadersMap().put(PropertiesStringEnum.SITEMINDER_SESSION_COOKIE.value(), null);

        wsRequest.setUrl(url);

        try {
            RestResponse response = RestUtil.executeMethod(client, wsRequest);

            municipalities = toMunicipalities(IOUtils.toInputStream(response.getResponse()));

        } catch (Exception e) {
            _log.error(e);
            throw new PortalException(e);
        }

        return municipalities;
    }

    private List<MunicipalityType> toMunicipalities(InputStream inputStream) {

        List<MunicipalityType> municipalities = null;

        try {
            JAXBContext jc = JAXBContext.newInstance(ListOfPoliticalEntities.class, Errors.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Object object = unmarshaller.unmarshal(inputStream);
            if (object instanceof Errors) {
                Errors errors = (Errors) object;

                if (errors != null) {
                    for (ErrorType errorType : errors.getError()) {
                        _log.error("Erreur renvoyée par refinf : " + errorType.getMessage() + "(Code : "
                                + errorType.getCode() + ")");
                    }
                }
            } else {
                ListOfPoliticalEntities listOfPoliticalEntities = (ListOfPoliticalEntities) object;
                municipalities = listOfPoliticalEntities.getListOfResults().getListOfMunicipalities().getMunicipality();
            }

        } catch (Exception e) {
            _log.error("Erreur d'accès aux données refinf : " + e);

            try {
                JAXBContext jcErrors = JAXBContext.newInstance(Errors.class);

                Unmarshaller errorsUnmarshaller = jcErrors.createUnmarshaller();

                Errors errors = (Errors) errorsUnmarshaller.unmarshal(inputStream);

                if (errors != null) {
                    for (ErrorType errorType : errors.getError()) {
                        _log.error("Erreur renvoyée par refinf : " + errorType.getClass() + "(Code : "
                                + errorType.getCode() + ")");
                    }
                }

            } catch (JAXBException e1) {
                _log.error("Erreur d'affichage de l'erreur refinf : " + e1);
            }

        }

        return municipalities;
    }*/
}
