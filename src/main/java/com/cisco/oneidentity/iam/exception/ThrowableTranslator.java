package com.cisco.oneidentity.iam.exception;

import org.springframework.http.HttpStatus;

import reactor.core.publisher.Mono;

public class ThrowableTranslator {

    private final HttpStatus httpStatus;
    private final String message;

    private ThrowableTranslator(final Throwable throwable) {
        this.httpStatus = getStatus(throwable);
        this.message = throwable.getMessage();
    }

    private HttpStatus getStatus(final Throwable error) {
        if (error instanceof ClientException) {
            return HttpStatus.BAD_REQUEST;
        }else {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public static <T extends Throwable> Mono<ThrowableTranslator> translate(final Mono<T> throwable) {
        return throwable.flatMap(error -> Mono.just(new ThrowableTranslator(error)));
    }
}
