package com.usermanagementsystem.exception;

public class BaseException extends RuntimeException{
	
	private String statusMessage;
	private long statusCode;
	private boolean successStatus;
	
	public BaseException(String statusMessage, long statusCode, boolean successStatus) {
		this.statusMessage = statusMessage;
		this.statusCode = statusCode;
		this.successStatus = successStatus;
	}
	
	
	public String getStatusMessage() {
		return statusMessage;
	}
	public long getStatusCode() {
		return statusCode;
	}
	public boolean isSuccessStatus() {
		return successStatus;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public void setStatusCode(long statusCode) {
		this.statusCode = statusCode;
	}
	public void setSuccessStatus(boolean successStatus) {
		this.successStatus = successStatus;
	}
	
	

}
