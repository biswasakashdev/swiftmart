package com.biswasakashdev.swiftmart.gateway.controller.gpql;


import com.biswasakashdev.swiftmart.gateway.clients.AccountsClient;
import com.biswasakashdev.swiftmart.gateway.dtos.models.users.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UsersController {

    private final AccountsClient accountsClient;

    @QueryMapping
    public Mono<User> user(Authentication authentication) {
        String userId =(String) authentication.getPrincipal();
        return accountsClient.fetchUser(userId);
    }
}
