package com.biswasakashdev.swiftmart.gateway.controller;


import com.biswasakashdev.swiftmart.gateway.clients.AccountsClient;
import com.biswasakashdev.swiftmart.gateway.dtos.inputs.users.CreateUserInp;
import com.biswasakashdev.swiftmart.gateway.dtos.inputs.CredentialsInp;
import com.biswasakashdev.swiftmart.gateway.dtos.models.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class UsersController {

    private final AccountsClient accountsClient;

    @MutationMapping
    public Mono<Authorization> authorize(@Argument CredentialsInp inp){
        return accountsClient.authorize(inp);
    }

    @MutationMapping
    public Mono<Boolean> createUser(@Argument CreateUserInp inp){
        return accountsClient
                .createUser(inp)
                .then(Mono.just(Boolean.TRUE));
    }

}
