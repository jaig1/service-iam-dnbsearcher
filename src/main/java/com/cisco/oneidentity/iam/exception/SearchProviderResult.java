package com.cisco.oneidentity.iam.exception;

import java.util.List;
import java.util.Map;

import com.cisco.oneidentity.iam.constants.SearchResultType;
import com.cisco.oneidentity.iam.model.SearchResponse;

public class SearchProviderResult{
	private SearchResultType resultType;
	private Throwable throwable;
	private String message;
	
	public SearchProviderResult(SearchResultType resultType,String message ,Throwable throwable) {
		this.resultType = resultType;
		this.message=message;
		this.throwable = throwable;
	}

	public SearchResultType getResultType() {
		return resultType;
	}

	public Throwable getThrowable() {
		return throwable;
	}
}
