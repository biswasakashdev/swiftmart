package com.biswasakashdev.swiftmart.gateway.auth;


import com.biswasakashdev.swiftmart.common.service.JwtService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationManager implements ReactiveAuthenticationManager {

    private final JwtService jwtValidator; // custom service to call auth endpoint

    @Override
    @NonNull
    public Mono<Authentication> authenticate(@NonNull Authentication authentication) {
        return Mono.create((sink)->{

            String token = authentication.getCredentials().toString();
        });
    }
}
