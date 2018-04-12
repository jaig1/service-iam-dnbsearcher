package com.cisco.oneidentity.iam.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import com.cisco.oneidentity.iam.constants.SearchResultType;
import com.cisco.oneidentity.iam.exception.ClientException;
import com.cisco.oneidentity.iam.model.CRPartyDetails;
import com.cisco.oneidentity.iam.processors.factory.DNBSearchFactory;
import com.cisco.oneidentity.iam.utils.CommonRoutines;

@Component
public class ApiHandler {
	
	private final ErrorHandler errorHandler;

	@Autowired
	private DNBSearchFactory dnbSearchFactory;

	public ApiHandler(final ErrorHandler errorHandler) {
			this.errorHandler = errorHandler;
	}
	
    public Mono<ServerResponse> dnbSearch(ServerRequest request) {
    	Mono<CRPartyDetails> CRPartyDetails = request.bodyToMono(CRPartyDetails.class);
        return  CRPartyDetails.transform(this::validateRequest)
        		.onErrorResume(errorHandler::throwableError);
        		
    }
    
	
  private  Mono<ServerResponse> validateRequest(final Mono<CRPartyDetails> request) {
	        return request.flatMap(requestMono -> {
	                    if (!CommonRoutines.isNullOrBlank(requestMono)&& !CommonRoutines.isNullOrBlank(requestMono.getCountryCode())&& !CommonRoutines.isNullOrBlank(requestMono.getEmail())) {
	                        return dnbSearchFactory.execute(CommonRoutines.buildDNBSearchPayload(requestMono));
	                    } else {
	                        return Mono.error(new ClientException(SearchResultType.UNSUPPORTED_DATA_IN_REQUEST.getValue()));
	                    }
	                }
	        );
	    }

}
