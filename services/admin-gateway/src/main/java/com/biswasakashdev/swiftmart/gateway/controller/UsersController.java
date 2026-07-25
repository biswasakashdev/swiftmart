package com.biswasakashdev.swiftmart.gateway.controller;


import com.biswasakashdev.swiftmart.gateway.dtos.models.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class UsersController {

    @QueryMapping
    public Mono<User> user(Authentication authentication){
        return Mono.just(User.builder().build());
    }
}
