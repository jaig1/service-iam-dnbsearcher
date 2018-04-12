package com.cisco.oneidentity.iam.routers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.cisco.oneidentity.iam.handlers.ApiHandler;
import com.cisco.oneidentity.iam.handlers.ErrorHandler;

public class ApiRouter {

    private static final String API_PATH = "/api/parties/search";
 
    static RouterFunction<ServerResponse> route(ApiHandler handler,ErrorHandler errorHandler) {
	    return RouterFunctions
                .route(POST(API_PATH).and(contentType(APPLICATION_JSON)), handler::dnbSearch);
	    	
    }
}
