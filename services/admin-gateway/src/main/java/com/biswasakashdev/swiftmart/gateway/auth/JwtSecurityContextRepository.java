package com.biswasakashdev.swiftmart.gateway.auth;


import com.google.common.net.HttpHeaders;
import lombok.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class JwtSecurityContextRepository implements ServerSecurityContextRepository {

    private final JwtAuthenticationManager authManager;

    public JwtSecurityContextRepository(JwtAuthenticationManager authManager) {
        this.authManager = authManager;
    }

    @Override
    @NonNull
    public Mono<Void> save(@NonNull ServerWebExchange exchange, SecurityContext context) {
        return Mono.empty(); // stateless
    }

    @Override
    @NonNull
    public Mono<SecurityContext> load(ServerWebExchange exchange) {
        String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            Authentication auth = new UsernamePasswordAuthenticationToken(token, token);
            return authManager.authenticate(auth).map(SecurityContextImpl::new);
        }
        return Mono.empty();
    }
}
