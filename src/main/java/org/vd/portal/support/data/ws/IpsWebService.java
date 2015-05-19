package org.vd.portal.support.data.ws;

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
import org.vd.portal.data.ws.rest.client.model.OrgList;
import org.vd.portal.support.data.ws.tools.PrestationsWsException;
import org.vd.portal.support.data.ws.tools.RestRequest;
import org.vd.portal.support.data.ws.tools.RestResponse;
import org.vd.portal.support.data.ws.tools.RestUtil;
import org.vd.portal.support.properties.file.ws.IpsProperties;

import javax.management.relation.RoleList;
import javax.ws.rs.HttpMethod;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.util.*;

/** Client du web Service IPS exposant l'API Rest d'IAM */
public class IpsWebService {

    /** Variables dynamiques */
    public static final String IPS_PARAM_IUP = "${iup}";
    public static final String IPS_PARAM_ORGID = "${orgId}";
    /** Logger */
    private final static Log _log = LogFactoryImpl.getLog(IpsWebService.class);
    /** User de connexion au web service */
    private static String WS_USERNAME = IpsProperties.USERNAME.value();
    /** Password de connexion au web service */
    private static String WS_PASSWORD = IpsProperties.PASSWORD.value();
    /** Url de connexion au web service */
    private static String WS_URL = IpsProperties.BASE_URL.value();
    /** Client de connexion */
    private HttpClient client;

    /** Constructeur */
    public IpsWebService() {

        //Initialisation client http
        if (client == null) {
            MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
            client = new HttpClient(connectionManager);
            client.getHttpConnectionManager().getParams().setConnectionTimeout(IpsProperties.TIMEOUT_CONNECT.intValue());
            client.getHttpConnectionManager().getParams().setSoTimeout(IpsProperties.TIMEOUT_REQUEST.intValue());
        }

        //Connexion sécurisée
        if (IpsProperties.AUTHENTIFICATION_ENABLED.boolValue()) {

            List<String> authPrefs = Arrays.asList(AuthPolicy.BASIC);
            client.getParams().setParameter(AuthPolicy.AUTH_SCHEME_PRIORITY, authPrefs);
            client.getParams().setAuthenticationPreemptive(true);

            Credentials credentials = new UsernamePasswordCredentials(WS_USERNAME, WS_PASSWORD);
            client.getState().setCredentials(new AuthScope(IpsProperties.AUTHENTIFICATION_SCOPE.value(), 80, AuthScope.ANY_REALM),
                    credentials);
        }
    }

    /**
     * Collecte la liste des organisations associées à l'utilisateur
     *
     * @param userName
     *
     * @return
     *
     * @throws Exception
     */
    private RestResponse executeOrgsList(String userName) throws Exception {

        String url = WS_URL + IpsProperties.ORGANIZATIONS_LIST.value();

        RestRequest wsRequest = new RestRequest();

        wsRequest.setRequestMethod(HttpMethod.GET);

        url = StringUtils.replace(url, IPS_PARAM_IUP, userName);

        wsRequest.setUrl(url);

        RestResponse response = RestUtil.executeMethod(client, wsRequest);

        return response;

    }

    /**
     * Collecte la liste des organisations associées à l'utilisateur
     *
     * @param userName
     *
     * @return
     *
     * @throws Exception
     */
    public OrgList getOrgsList(String userName) throws Exception {

        OrgList orgList;

        try {
            RestResponse response = executeOrgsList(userName);

            orgList = toOrgList(response);

        } catch (JAXBException e) {
            _log.error(e);
            throw new Exception(e);
        }

        return orgList;

    }

    /**
     * Convertit les listes d'organisations utilisateur en objet
     *
     * @param response
     *
     * @return
     *
     * @throws PrestationsWsException
     * @throws javax.xml.bind.JAXBException
     * @throws java.io.IOException
     */
    private OrgList toOrgList(RestResponse response) throws PrestationsWsException, JAXBException, IOException {

        OrgList orgList;

        JAXBContext jc = JAXBContext.newInstance(OrgList.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Object object = unmarshaller.unmarshal(
                IOUtils.toInputStream(response.getResponse(), IpsProperties.ENCODING.value()));
        if (object instanceof OrgList) {
            orgList = (OrgList) object;
        } else {
            _log.error("Response http status code : " + response.getStatusCode());

            throw new PrestationsWsException("", response.getStatusCode());
        }


        return orgList;
    }

    /**
     * Récupère les rôles utilisateurs associés à une organisation
     *
     * @param userName
     * @param orgaId
     *
     * @return
     *
     * @throws Exception
     */
    private RestResponse executeOrgRemoteRolesList(String userName, String orgaId) throws Exception {


        String url = WS_URL + IpsProperties.ROLES_LIST.value();

        RestRequest wsRequest = new RestRequest();

        wsRequest.setRequestMethod(HttpMethod.GET);

        url = StringUtils.replace(url, IPS_PARAM_IUP, userName);
        url = StringUtils.replace(url, IPS_PARAM_ORGID, orgaId);

        wsRequest.setUrl(url);

        RestResponse response = RestUtil.executeMethod(client, wsRequest);

        return response;

    }

    /**
     * Récupère les rôles utilisateurs associés à une organisation
     *
     * @param username login utilisateur
     * @param orgaId   id de l'organisation
     *
     * @return Liste des rôles associés à l'organisation
     *
     * @throws Exception
     */
    public RoleList getOrgRemoteRolesList(String username, String orgaId) throws Exception {

        RoleList roleList = null;

        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(orgaId)) {

            try {
                RestResponse response = executeOrgRemoteRolesList(username, orgaId);

                roleList = toRoleList(response);

            } catch (Exception e) {
                _log.error(e);
                throw new Exception(e);
            }

        }

        return roleList;

    }

    /**
     * Retourne l'ensemble des rôles par organisation
     *
     * @param username login utilisateur
     *
     * @return Rôles par organisation
     */
    public Map<String, RoleList> getRolesByOrganizations(String username) {

        //Récupère les ids des organisations auxquelles l'utilisateur est rattaché
        List<String> organizationIds = new ArrayList<String>();
        try {
            OrgList orgList = getOrgsList(username);
            organizationIds = orgList.getOrgId();
        } catch (Exception e) {
            _log.error("Impossible de récupérer les organisations associées à l'utilisateur [" + username + "]");
        }

        Map<String, RoleList> rolesByOrganization = new HashMap<String, RoleList>();
        for (String organizationId : organizationIds) {
            RoleList roleList = null;
            try {
                roleList = getOrgRemoteRolesList(username, organizationId);
                rolesByOrganization.put(organizationId, roleList);
            } catch (Exception e) {
                _log.error("Impossible de récupérer les rôles de l'organization [id:" + organizationId + " pour l'utilisateur [" + username + "]", e);
            }
        }

        return rolesByOrganization;
    }

    /**
     * Convertit la liste des rôles par organisation en objet
     *
     * @param response
     *
     * @return
     *
     * @throws PrestationsWsException
     * @throws javax.xml.bind.JAXBException
     * @throws java.io.IOException
     */
    private RoleList toRoleList(RestResponse response) throws PrestationsWsException, JAXBException, IOException {

        RoleList roleList;

        JAXBContext jc = JAXBContext.newInstance(RoleList.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Object object = unmarshaller.unmarshal(
                IOUtils.toInputStream(response.getResponse(), IpsProperties.ENCODING.value()));
        if (object instanceof RoleList) {
            roleList = (RoleList) object;
        } else {
            _log.error("Response http status code : " + response.getStatusCode());

            throw new PrestationsWsException("", response.getStatusCode());
        }


        return roleList;
    }
}
