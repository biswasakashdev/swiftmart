package com.biswasakashdev.swiftmart.gateway.filters;


import com.biswasakashdev.swiftmart.common.TokenType;
import com.biswasakashdev.swiftmart.common.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NullMarked;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtSessionAuthenticationFilter implements GatewayFilter {

    private final JwtService jwtService;


    @Override
    @NullMarked
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // Extract SESSIONID cookie
        HttpCookie sessionId = exchange.getRequest()
                .getCookies()
                .getFirst("SESSIONID");
        
        if(sessionId != null) {
            String sessionToken = sessionId.getValue();

            try{
                String authentication = jwtService.validate(sessionToken, TokenType.SESSION);

                // Mutate request to add Authentication-Info header
                ServerWebExchange mutatedExchange = exchange.mutate()
                        .request(r -> r.headers(headers -> headers.set("Authentication-Info", authentication)))
                        .build();

                return chain.filter(mutatedExchange);

            }catch (Throwable e){
                log.error("Session validation failed with message: {}, ",e.getMessage());
            }

        }

        // Redirect to /auth if missing or invalid
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.SEE_OTHER); // 303 redirect
        response.getHeaders().setLocation(exchange.getRequest().getURI().resolve("/auth"));
        return response.setComplete();
    }

}
