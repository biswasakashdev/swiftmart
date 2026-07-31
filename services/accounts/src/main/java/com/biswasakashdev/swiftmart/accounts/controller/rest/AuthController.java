package com.biswasakashdev.swiftmart.accounts.controller.rest;


import com.biswasakashdev.swiftmart.accounts.dtos.req.NewUserRequest;
import com.biswasakashdev.swiftmart.accounts.dtos.req.UserCredentials;
import com.biswasakashdev.swiftmart.accounts.dtos.res.Authorization;
import com.biswasakashdev.swiftmart.accounts.dtos.res.SessionDetails;
import com.biswasakashdev.swiftmart.accounts.dtos.res.UserResponse;
import com.biswasakashdev.swiftmart.accounts.models.User;
import com.biswasakashdev.swiftmart.accounts.services.AuthService;
import com.biswasakashdev.swiftmart.accounts.services.UserService;
import com.biswasakashdev.swiftmart.common.TokenType;
import com.biswasakashdev.swiftmart.common.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpResponse;
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
            @RequestParam(name = "rememberMe", required = false, defaultValue = "false") boolean rememberMe,
            ServerHttpResponse response
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

                    ResponseCookie cookie = ResponseCookie.from("SESSIONID", token)
                            .httpOnly(true)          // Prevent client-side JS access
                            .path("/")               // Cookie valid for entire domain
                            .maxAge(duration.getSeconds())            // Expiration in seconds
                            .build();

                    response.addCookie(cookie);

                    SessionDetails sessionDetails = new SessionDetails(
                            token,
                            duration.toSeconds()
                    );

                    return Mono.just(sessionDetails);
                });
    }

    @GetMapping
    public Mono<Authorization> getAuthorization(@RequestHeader("Authentication-Info") String userId) {
        return userService
                .findUserById(userId)
                .map(user -> {

                    String token = jwtService.buildToken(user.getId(), Duration.ofMinutes(15), TokenType.AUTHORIZATION, new HashMap<>());

                    return new Authorization(
                            token,
                            new UserResponse(
                                    user.getEmail(),
                                    user.getName(),
                                    user.getAvatar()
                            )
                    );
                });
    }

}
