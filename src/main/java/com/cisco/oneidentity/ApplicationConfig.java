package com.cisco.oneidentity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import com.cisco.oneidentity.iam.handlers.ApiHandler;
import com.cisco.oneidentity.iam.handlers.ErrorHandler;
import com.cisco.oneidentity.iam.routers.MainRouter;
 
@Configuration
@ComponentScan(basePackages = "com.cisco")
public class ApplicationConfig {
  
    @Bean
    ErrorHandler errorHandler() {
        return new ErrorHandler();
    }
    
    @Bean
    ApiHandler apiHandler(final ErrorHandler errorHandler) {
        return new ApiHandler(errorHandler);
    }
    
    @Bean
    RouterFunction<?> mainRouterFunction(final ApiHandler apiHandler, final ErrorHandler errorHandler) {
        return MainRouter.doRoute(apiHandler, errorHandler);
    }
}
