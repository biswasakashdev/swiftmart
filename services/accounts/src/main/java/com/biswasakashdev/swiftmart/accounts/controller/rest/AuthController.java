package com.biswasakashdev.swiftmart.accounts.controller.rest;


import com.biswasakashdev.swiftmart.accounts.dtos.req.NewUserRequest;
import com.biswasakashdev.swiftmart.accounts.dtos.req.UserCredentials;
import com.biswasakashdev.swiftmart.accounts.dtos.res.SessionDetails;
import com.biswasakashdev.swiftmart.accounts.models.User;
import com.biswasakashdev.swiftmart.accounts.services.AuthService;
import com.biswasakashdev.swiftmart.accounts.services.UserService;
import com.biswasakashdev.swiftmart.common.TokenType;
import com.biswasakashdev.swiftmart.common.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;
    private final JwtService jwtService;

    @PostMapping(value = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> registerUser(
            @RequestBody NewUserRequest newUser
    ) {
        return userService
                .createUser(newUser)
                .then();
    }

    /**
     * Generate session when user logged in with email and password.
     */

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<SessionDetails> login(
            @RequestBody UserCredentials credentials,
            @RequestParam(name = "rememberMe", required = false, defaultValue = "false") boolean rememberMe
    ) {

//        How many days the generated session token valid.
        Duration duration = rememberMe ? Duration.ofDays(15) : Duration.ofDays(1);

        Mono<User> usersMono = authService.verify(credentials);

        return usersMono
                .flatMap(users -> {

                    String token = jwtService.buildToken(
                            users.getId(),
                            Duration.ofHours(1),
                            TokenType.SESSION,
                            new HashMap<>()
                    );


                    SessionDetails sessionDetails = new SessionDetails(
                            token,
                            duration.toSeconds()
                    );

                    return Mono.just(sessionDetails);
                });
    }

}
