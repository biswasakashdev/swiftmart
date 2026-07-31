package com.biswasakashdev.swiftmart.gateway.filters;

import com.biswasakashdev.swiftmart.common.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NullMarked;
import org.springframework.cloud.gateway.filter.GlobalFilter;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserInfoLoggerFilter implements GlobalFilter, Ordered {

    private final JwtService jwtService;

    @Override
    @NullMarked
    public Mono<Void> filter(ServerWebExchange exchange,
                             org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {



        String path = exchange.getRequest().getURI().getPath();

        // Log user info and request path
        log.info("UserInfo [{}]", path);

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // Run early in the chain
        return -1;
    }
}
