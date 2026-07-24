package com.biswasakashdev.swiftmart.gateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;

import java.util.Objects;

@Configuration
public class GatewayConfig {

    private final String accountsUrl;

    public GatewayConfig(Environment environment){
        String url = environment.getProperty("accounts.url");

        if(Objects.isNull(url) || url.isBlank()){
            throw new IllegalArgumentException("Invalid accounts url found");
        }

        accountsUrl = url;
    }

    @Bean
    RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {

        return routeLocatorBuilder.routes()
                .route("auth", (r) -> r
                        .method(HttpMethod.POST)
                        .and()
                        .path(
                                "/api/v1/auth/register",
                                "/api/v1/auth"
                        )
                        .uri(accountsUrl)
                )
                .build();
    }
}
