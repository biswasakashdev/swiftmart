package com.biswasakashdev.swiftmart.gateway.config;


import com.biswasakashdev.swiftmart.gateway.auth.JwtAuthenticationManager;
import com.biswasakashdev.swiftmart.gateway.auth.JwtSecurityContextRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http,
                                                            JwtAuthenticationManager authManager,
                                                            JwtSecurityContextRepository contextRepo) {
        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/api/v1/graphql")
                        .authenticated()
                        .anyExchange()
                        .permitAll()
                )
                .securityContextRepository(contextRepo)
                .build();
    }
}
