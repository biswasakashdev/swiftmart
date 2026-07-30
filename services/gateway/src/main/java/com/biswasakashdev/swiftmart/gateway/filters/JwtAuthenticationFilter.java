package com.biswasakashdev.swiftmart.gateway.filters;


import com.biswasakashdev.swiftmart.common.service.JwtService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NullMarked;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;


@Slf4j
@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter implements WebFilter {

    private final JwtService jwtService;

    @Override
    @NullMarked
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        Mono<SecurityContext> securityContext = ReactiveSecurityContextHolder.getContext();

        return securityContext
                .switchIfEmpty(Mono.just(new SecurityContextImpl()))
                .flatMap(context -> verifyToken(exchange, chain));

    }

    private Mono<Void> verifyToken(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        ServerHttpResponse response = exchange.getResponse();

        String authHeader = request.getHeaders().getFirst("Authorization");

        if (Objects.nonNull(authHeader) && authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7);

            try {

                String userId = jwtService.getUserId(token);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userId, "", List.of());
                SecurityContext context = new SecurityContextImpl(authenticationToken);
                return chain.filter(exchange)
                        .contextWrite(ReactiveSecurityContextHolder.withSecurityContext(Mono.just(context)));
                // return chain.filter(exchange);
            } catch (ExpiredJwtException ex) {
                return buildResponse("Expired authentication toke.", ex.getMessage(), response);
            } catch (MalformedJwtException ex) {
                return buildResponse("Invalid authentication found.", ex.getMessage(), response);
            } catch (RuntimeException ex) {
                return buildResponse("Authentication error", ex.getMessage(), response);
            }
        }
        return chain.filter(exchange);
    }

    private Mono<Void> buildResponse(String resMessage, String errLog, ServerHttpResponse response) {
        log.error("Error occurred while validating the JWT with message: {}", errLog);
        response.getHeaders().add("WWW-Authenticate", resMessage);
        return response.setComplete();
    }
}

