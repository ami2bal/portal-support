package org.vd.portal.support.data.ws.tools;

public class RestResponse {

    /** Réponse Rest */
    private String response;

    /** Code réponse */
    private int statusCode;

    /**
     * Constructeur
     *
     * @return
     */
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }


}
