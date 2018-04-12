package com.cisco.oneidentity.iam.constants;

public enum SearchResultType {
	
	SUCCESS("Success"),
	UNKNOWN_ERROR("Unknown Error Occurred. Contact COI support and provide your request ID."),
	INVALID_FILTER("Filter used is not allowed or invalid."),
	BAD_REQUEST("Request does not follow API protocol."),
	UNSUPPORTED_SERVICE_TYPE("Service type is not defined."),
	UNSUPPORTED_DATA_IN_REQUEST("country code and domain are mandatory fields");
	
	private String value;

	SearchResultType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
