package com.cisco.oneidentity.iam.processors.services;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import com.cisco.oneidentity.iam.model.GatewayRequest;
import com.cisco.oneidentity.iam.model.SearchResponse;

public interface DNBIntegration {
	
	public Mono<ServerResponse> dnbSearcher(Mono<GatewayRequest<?>> request);
	
	public  Mono<ServerResponse> processDNBSearch(UUID requestId,GatewayRequest<?> request);
	
}
