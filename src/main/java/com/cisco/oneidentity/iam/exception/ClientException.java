package com.cisco.oneidentity.iam.exception;


public class ClientException extends RuntimeException{


	private static final long serialVersionUID = 1807037653888930881L;
	private String error_message;

	public ClientException(String error_message){
		super(error_message);
		this.error_message = error_message;
	}

	public String getError_message() {
		return error_message;
	}
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

}
