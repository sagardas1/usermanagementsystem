package com.usermanagementsystem.baseResponce;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;

public class BaseResponce implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private Object object;
	private String statusMessage;
	private long statusCode;
	private boolean successStatus;
	BaseResponce(){
		
	}
	
	
	public BaseResponce(Object object, String statusMessage, long statusCode, boolean successStatus) {
		super();
		this.object = object;
		this.statusMessage = statusMessage;
		this.statusCode = statusCode;
		this.successStatus = successStatus;
	}
	public static BaseResponce setBaseResponce(Object object, String statusMessage, long statusCode, boolean successStatus) {
		BaseResponce baseResponce=new BaseResponce(object, statusMessage, statusCode, successStatus);
		return baseResponce;
		
		
	}


	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public long getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(long statusCode) {
		this.statusCode = statusCode;
	}

	public Object getObject() {
		return object;
	}

	public boolean isSuccessStatus() {
		return successStatus;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public void setSuccessStatus(boolean successStatus) {
		this.successStatus = successStatus;
	}

	


}
