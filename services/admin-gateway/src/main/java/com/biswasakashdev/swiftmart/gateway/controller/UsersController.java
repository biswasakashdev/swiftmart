package com.biswasakashdev.swiftmart.gateway.controller;


import com.biswasakashdev.swiftmart.gateway.dtos.models.users.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UsersController {

    @QueryMapping
    public Mono<User> user() {
        return ReactiveSecurityContextHolder.getContext()
                .mapNotNull(SecurityContext::getAuthentication)
                .flatMap(authentication -> {
                    log.info("Principal: {}", authentication.getPrincipal());

                    // Map your Security Principal (e.g., Jwt, UserDetails) to your User object
                    User user = User.builder()
                            .id("123") // Must provide required non-null fields
                            .name("John Doe")
                            .email("john@example.com")
                            .avatar("https://example.com/avatar.png")
                            .build();

                    return Mono.just(user);
                });
    }
}
