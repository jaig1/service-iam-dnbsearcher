package com.cisco.oneidentity.iam.processors.services.impl;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import com.cisco.oneidentity.iam.constants.OneIDConstants;
import com.cisco.oneidentity.iam.model.CRParties;
import com.cisco.oneidentity.iam.model.CompanyDetails;
import com.cisco.oneidentity.iam.model.DNBSearchRequest;
import com.cisco.oneidentity.iam.model.DNBSearchResponse;
import com.cisco.oneidentity.iam.model.GatewayRequest;
import com.cisco.oneidentity.iam.model.GatewayResponse;
import com.cisco.oneidentity.iam.processors.services.DNBIntegration;
import com.cisco.oneidentity.iam.processors.utils.DNBSearchHelper;

@Service
public class DNBIntegrationImpl implements DNBIntegration{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DNBIntegrationImpl.class);


	@Override
	public Mono<ServerResponse> dnbSearcher(GatewayRequest<?> request){
		Mono<GatewayResponse<?>> searchResult = processDNBSearch(request);
		return processSearchResultFromProvider(searchResult);
	}
	
	private Mono<GatewayResponse<?>> processDNBSearch(GatewayRequest<?> request){		
			Mono<DNBSearchResponse> dnbSearchResponse = DNBSearchHelper.invokeDNB((DNBSearchRequest)request.getRequest());	
	return dnbSearchResponse.flatMap((response)->	generateResponse(response));	
	}
	private Mono<GatewayResponse<?>> generateResponse(DNBSearchResponse dnbSearchResponse){
		GatewayResponse<Object> result = new GatewayResponse<Object>();
		CRParties CRParties = new CRParties();
		List<CompanyDetails> partiesList = new ArrayList<CompanyDetails>();
		dnbSearchResponse.getParties().stream().forEach(parties ->{
				CompanyDetails companyDetails = new CompanyDetails();
				companyDetails.setDunsNumber(parties.getDunsNumber());
				parties.getData().stream().forEach((partyAddress) -> {
					companyDetails.setCountryName(partyAddress.getCountryName());
					companyDetails.setPartyName(partyAddress.getPartyName());
				});
			 partiesList.add(companyDetails);
		}); 
		CRParties.setCompanyDetails(partiesList);
		result.setResponseBody(CRParties);	
		result.setStatus(OneIDConstants.STATUS_SUCCESS);
	return Mono.just(result);
	}

	private Mono<ServerResponse> processSearchResultFromProvider(Mono<GatewayResponse<?>> result) {
		
		Mono<ServerResponse> notFound = ServerResponse.notFound().build();
		return result
        .flatMap(gatewayResponse -> ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(fromObject(gatewayResponse.getResponseBody())))
        .switchIfEmpty(notFound);
		 
	}
 
}
