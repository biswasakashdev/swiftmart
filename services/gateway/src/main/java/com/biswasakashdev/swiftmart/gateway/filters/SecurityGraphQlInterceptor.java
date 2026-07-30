package com.biswasakashdev.swiftmart.gateway.filters;


import org.jspecify.annotations.NullMarked;
import org.springframework.graphql.server.WebGraphQlInterceptor;
import org.springframework.graphql.server.WebGraphQlRequest;
import org.springframework.graphql.server.WebGraphQlResponse;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class SecurityGraphQlInterceptor implements WebGraphQlInterceptor {

    @Override
    @NullMarked
    public Mono<WebGraphQlResponse> intercept(WebGraphQlRequest request, Chain chain) {
        return ReactiveSecurityContextHolder.getContext()
                .switchIfEmpty(Mono.just(new SecurityContextImpl()))
                .mapNotNull(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .doOnNext(auth -> {
                    // Inject into GraphQL execution context
                    request.configureExecutionInput((executionInput, builder) ->
                            builder.graphQLContext(contextBuilder -> {
                                contextBuilder.put("authentication", auth);
                                contextBuilder.put("principal", auth.getPrincipal());
                            }).build()
                    );
                })
                .then(chain.next(request))
                // If missing or unauthenticated, throw an exception to break the chain
                .switchIfEmpty(
                        Mono.error(new AuthenticationCredentialsNotFoundException("Unauthorized: Missing or invalid JWT token"))
                );

    }
}
