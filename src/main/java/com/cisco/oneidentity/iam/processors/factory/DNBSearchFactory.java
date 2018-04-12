package com.cisco.oneidentity.iam.processors.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import com.cisco.oneidentity.iam.constants.OneIDConstants;
import com.cisco.oneidentity.iam.constants.SearchResultType;
import com.cisco.oneidentity.iam.exception.ClientException;
import com.cisco.oneidentity.iam.model.GatewayRequest;
import com.cisco.oneidentity.iam.processors.services.impl.DNBIntegrationImpl;
import com.cisco.oneidentity.iam.utils.Provider;

@Service
public class DNBSearchFactory {
	
	private static final Logger logger = LoggerFactory.getLogger(DNBSearchFactory.class);
	
	public Mono<ServerResponse> execute(GatewayRequest<?>request){
		if(request.getServiceType().equals(OneIDConstants.DNB_SEARCH)) {
			return  (Mono<ServerResponse>) provider.getBeanByType(DNBIntegrationImpl.class).dnbSearcher(request);
		}else{
			return Mono.error(new ClientException(SearchResultType.UNSUPPORTED_SERVICE_TYPE.getValue()));
		}
	}

	@Autowired
	private Provider provider; 
}
