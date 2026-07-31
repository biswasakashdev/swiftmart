package com.biswasakashdev.swiftmart.gateway.config;


import com.biswasakashdev.swiftmart.gateway.filters.JwtSessionAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {

    private final ApplicationConfig applicationConfig;

    private final JwtSessionAuthenticationFilter jwtSessionAuthenticationFilter;


    private static final String [] WEB_CLIENT_PUBLIC_ENDPOINTS = {
            "/",
            "/auth/**",
            "/_next/**",
            "/favicon.ico",
    };



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
                        .uri(applicationConfig.accountsRest())
                )
                .route("secured",r->r
                        .method(HttpMethod.GET)
                        .and()
                        .path("/api/v1/auth")
                        .filters(f->f.filter(jwtSessionAuthenticationFilter))
                        .uri(applicationConfig.accountsRest()))
                .route("client-public",r->r
                        .method(HttpMethod.GET)
                        .and()
                        .path(WEB_CLIENT_PUBLIC_ENDPOINTS)
                        .uri(applicationConfig.webRest())
                ).route("client-secured",r->r
                        .method(HttpMethod.GET)
                        .and()
                        .path("/home/**")
                        .filters(f->f.filter(jwtSessionAuthenticationFilter))
                        .uri(applicationConfig.webRest())
                )
                .build();
    }
}
