package org.vd.portal.support.data.ws.tools;

public class PrestationsWsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int httpStatusCode;
	
	public PrestationsWsException (Throwable e) {
		super(e);
	}
	
	public PrestationsWsException (String msg) {
		this (msg, 400);
	}
	
	public PrestationsWsException (String msg, int statusCode) {
		super(msg);
		
		httpStatusCode = statusCode;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
	
	
}
