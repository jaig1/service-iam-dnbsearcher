package com.cisco.oneidentity.iam.processors.utils;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

import com.cisco.oneidentity.iam.constants.Property;
import com.cisco.oneidentity.iam.model.DNBSearchRequest;
import com.cisco.oneidentity.iam.model.DNBSearchResponse;

@Service
public class DNBSearchHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(DNBSearchHelper.class);
	
	public static Mono<DNBSearchResponse> invokeDNB(DNBSearchRequest companyDetails) {
	  	  WebClient accessTokenUrl =  WebClient.create(Property.ACCESS_TOCKEN_ENDPOINT.getValue());
	  	  WebClient dnbSearchUrl =  WebClient.create(Property.DNB_SEARCH_ENDPOINT.getValue());
	      Mono<DNBSearchResponse> dnbResponsePayload = accessTokenUrl.get()
		       		   	.uri(Property.ACCESS_TOCKEN_URI.getValue())
		       		   	.accept(MediaType.APPLICATION_JSON)
		       		   	.exchange()
		       		   	.flatMap(response -> response.bodyToMono(Map.class))
		       		   	.map(response -> response.get("access_token")) 
		       		   	.flatMap(accessToken ->
		       		   	dnbSearchUrl.post()
	       		   		.uri(Property.DNB_SEARCH_URI.getValue())
	       		   		.header("authorization", "Bearer "+accessToken)
	       		   		.accept(MediaType.APPLICATION_JSON)
	       		   		.syncBody(companyDetails)
	       		   		.exchange()
	       		   		.flatMap(response -> response.bodyToMono(DNBSearchResponse.class))
	       		  ); 
	return dnbResponsePayload;
	}
	
}
