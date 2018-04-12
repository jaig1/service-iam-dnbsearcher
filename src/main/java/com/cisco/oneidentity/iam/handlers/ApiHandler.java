package com.cisco.oneidentity.iam.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

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
        return  dnbSearchFactory.execute(CRPartyDetails.flatMap((paryRequest)->	CommonRoutines.buildDNBSearchPayload(paryRequest)))
        		.onErrorResume(errorHandler::throwableError);
    }

}
