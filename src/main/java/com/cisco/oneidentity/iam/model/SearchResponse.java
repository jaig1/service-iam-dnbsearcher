package com.cisco.oneidentity.iam.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.cisco.oneidentity.iam.constants.ResponseResults;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value = { "requestId", "result", "response" })
public class SearchResponse<T> {

	@JsonProperty("requestId") private String requestId;

    @JsonProperty("result") private ResponseResults result;

    @JsonProperty("response") private T response;
    
	public SearchResponse(String requestId, ResponseResults result, T response) {
		 this.requestId = requestId;
	     this.result = result;
	     this.response = response;
	}
	 protected SearchResponse() {}

	    public String getRequestId() {
	        return requestId;
	    }

	    public void setRequestId(String requestId) {
	        this.requestId = requestId;
	    }

	    public ResponseResults getResult() {
	        return result;
	    }

	    public void setResult(ResponseResults result) {
	        this.result = result;
	    }

	    public T getResponse() {
	        return response;
	    }

	    public void setResponse(T response) {
	        this.response = response;
	    }

	    @Override public String toString() {
	        return getClass().getName() + "{" + "requestId='" + getRequestId() + '\'' + ", result=" + getResult()
	                + ", " + "response=" + getResponse() + '}';
	    }
}
