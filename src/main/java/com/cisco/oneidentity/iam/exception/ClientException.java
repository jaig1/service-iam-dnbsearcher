package com.cisco.oneidentity.iam.exception;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import reactor.core.publisher.Mono;

import com.cisco.oneidentity.iam.constants.ResponseResults;
import com.cisco.oneidentity.iam.constants.SearchResultType;
import com.cisco.oneidentity.iam.model.SearchResponse;


public class ClientException extends RuntimeException{


	private static final long serialVersionUID = 1807037653888930881L;
	private String resultType;
	private String error_message;

	public ClientException(String resultType,String error_message){
		super(error_message);
		this.resultType = resultType;
		this.error_message = error_message;
	}
 
	public String getError_code() {
		return resultType;
	}
	public void setError_code(String resultType) {
		this.resultType = resultType;
	}
	public String getError_message() {
		return error_message;
	}
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
	

	public static Mono<ResponseEntity<SearchResponse<?>>> handleExceptions(Throwable e) {
		UUID requestId = UUID.randomUUID();
		return Mono.just(new ResponseEntity<SearchResponse<?>>(
				new SearchResponse(requestId.toString(), ResponseResults.FAIL, new SearchProviderResult(SearchResultType.UNKNOWN_ERROR,SearchResultType.UNKNOWN_ERROR.getValue(), e)),HttpStatus.BAD_REQUEST));
		 
	}
	
}
