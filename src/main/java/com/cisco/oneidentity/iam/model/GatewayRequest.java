package com.cisco.oneidentity.iam.model;

public class GatewayRequest<T> {

	private T request;
	private String serviceType;
	private String status;

	public T getRequest() {
		return request;
	}
	public void setRequest(T request) {
		this.request = request;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	
}
