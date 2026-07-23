package com.biswasakashdev.swiftmart.gateway.controller;


import com.biswasakashdev.swiftmart.gateway.dtos.inputs.client.CreateClientInp;
import com.biswasakashdev.swiftmart.gateway.dtos.inputs.CredentialsInput;
import com.biswasakashdev.swiftmart.gateway.dtos.models.User;
import com.biswasakashdev.swiftmart.gateway.dtos.models.Authorization;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class AccountsController {



    @MutationMapping
    public Mono<Authorization> verify(@Argument CredentialsInput inp){
        return Mono.just(new Authorization(
                "",
                new User("","")
        ));
    }

    @MutationMapping
    public Mono<Boolean> createClient(@Argument CreateClientInp inp){
        return Mono.just(Boolean.TRUE);
    }

}
