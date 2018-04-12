package com.cisco.oneidentity.iam.routers;

import org.springframework.web.reactive.function.server.RouterFunction;

import com.cisco.oneidentity.iam.handlers.ApiHandler;
import com.cisco.oneidentity.iam.handlers.ErrorHandler;

public class MainRouter {

    public static RouterFunction<?> doRoute(final ApiHandler handler, final ErrorHandler errorHandler) {
        return ApiRouter
                .route(handler,errorHandler);
    }
}
