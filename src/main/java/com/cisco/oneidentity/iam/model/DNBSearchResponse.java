package com.cisco.oneidentity.iam.model;

import java.util.List;

public class DNBSearchResponse {
	
	private String bodID;	 
	private String referenceID;
	private String componentID;	 
	private String status;
	private String errorCode;
	private String errorMessage;
	private String numFound;
	private List<Parties> parties;

	public String getBodID() {
		return bodID;
	}
	public void setBodID(String bodID) {
		this.bodID = bodID;
	}
	public String getReferenceID() {
		return referenceID;
	}
	public void setReferenceID(String referenceID) {
		this.referenceID = referenceID;
	}
	public String getComponentID() {
		return componentID;
	}
	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getNumFound() {
		return numFound;
	}
	public void setNumFound(String numFound) {
		this.numFound = numFound;
	}
	public List<Parties> getParties() {
		return parties;
	}
	public void setParties(List<Parties> parties) {
		this.parties = parties;
	}

}
