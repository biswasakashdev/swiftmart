package com.biswasakashdev.swiftmart.gateway.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public record ApplicationConfig (
        @Value("${clients.accounts.rest}")
        String accountsRest,
        @Value("${clients.accounts.grpc}")
        String accountsGrpc,
        @Value("${clients.web.rest}")
        String webRest
) {

}
