package org.vd.portal.support.data.ws.tools;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

import javax.ws.rs.HttpMethod;
import java.util.Map.Entry;


/** Classe utilitaire pour web service Rest */
public class RestUtil {


    /** Logger */
    private static Logger _log = Logger.getLogger(RestUtil.class.getName());

    /**
     * Exécute un appel Rest
     *
     * @param client
     * @param restRequest
     *
     * @return
     */
    public static RestResponse executeMethod(HttpClient client, RestRequest restRequest) {
        RestResponse response = null;

        HttpMethodBase httpMethod = null;

        try {

            _log.info("Rest call url : " + restRequest.getUrl());

            //Url
            String url = restRequest.getUrl();

            //Method
            if (HttpMethod.GET.equals(restRequest.getRequestMethod())) {
                httpMethod = new GetMethod(url);
            } else if (HttpMethod.POST.equals(restRequest.getRequestMethod())) {

                //Http Parameters
                NameValuePair[] data = null;
                if (restRequest.getParametersMap() != null) {
                    data = new NameValuePair[restRequest.getParametersMap().size()];

                    int i = 0;
                    for (Entry<String, String> param : restRequest.getParametersMap().entrySet()) {
                        data[i++] = new NameValuePair(param.getKey(), param.getValue());
                    }
                }

                PostMethod method = new PostMethod(url);
                method.setRequestBody(data);
                httpMethod = method;
            }

            //Header parameters
            if (restRequest.getHeadersMap() != null) {
                for (Entry<String, String> param : restRequest.getHeadersMap().entrySet()) {
                    httpMethod.addRequestHeader(param.getKey(), param.getValue());
                }
            }

            //Authentification
            if (restRequest.isDoAuthentication()) {
                httpMethod.setDoAuthentication(true);
            }

            //Exécution de la requête
            int status = client.executeMethod(httpMethod);

            _log.info("Rest call response status is : " + status);

            //Réponse de la requête
            response = new RestResponse();
            response.setResponse(httpMethod.getResponseBodyAsString());
            response.setStatusCode(httpMethod.getStatusCode());

        } catch (Exception e) {
            _log.error(e);
        } finally {

            //Clôture de la connexion
            if (httpMethod != null) {
                httpMethod.releaseConnection();
            }
        }

        return response;

    }

}
