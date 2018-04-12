package com.cisco.oneidentity.iam.model;

public class DNBSearchRequest {
	
	private String bodID;	 
	private String referenceID;
	private String componentID;	 
	private String timestamp;
	private RegistrationDetails dataArea;

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
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public RegistrationDetails getDataArea() {
		return dataArea;
	}
	public void setDataArea(RegistrationDetails dataArea) {
		this.dataArea = dataArea;
	}
}
