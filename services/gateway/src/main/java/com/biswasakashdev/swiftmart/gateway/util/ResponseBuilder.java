package com.biswasakashdev.swiftmart.gateway.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

@Slf4j
public class ResponseBuilder {

    public static Mono<Void> buildResponse(String resMessage, ServerHttpResponse response) {
        response.getHeaders().add("WWW-Authenticate", resMessage);
        return response.setComplete();
    }
}
