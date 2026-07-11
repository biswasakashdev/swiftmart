package com.biswasakashdev.swiftmart.core.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeRequest;
import com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeResponse;
import com.biswasakashdev.swiftmart.core.services.AuthService;
import com.biswasakashdev.swiftmart.core.services.JwtService;
import com.biswasakashdev.swiftmart.core.services.UserService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public Mono<AuthorizeResponse> authorize(AuthorizeRequest request) {

        return userService
                .findUserByEmail(request.getEmail())
                .map(fetchedUser -> {
                    boolean isPasswordMatch = passwordEncoder.matches(request.getPassword(), fetchedUser.getPassword());
                    if (isPasswordMatch) {

                        AuthorizeResponse.UserResponse userResponse= AuthorizeResponse.UserResponse.newBuilder()
                                .setFirstName(fetchedUser.getFirstName())
                                .setLastName(fetchedUser.getLastName())
                                .setEmail(fetchedUser.getEmail())
                                .build();

                        String token = jwtService.buildToken(fetchedUser.getId(), Duration.ofDays(1),new HashMap<>());

                        AuthorizeResponse.Authorization authorization = AuthorizeResponse.Authorization.newBuilder()
                                .setToken(token)
                                .setUserResponse(userResponse)
                                .build();

                        return AuthorizeResponse.newBuilder()
                                .setAuthorization(authorization)
                                .build();
                    }
                    return AuthorizeResponse
                            .newBuilder()
                            .setError("Invalid credentials")
                            .build();

                });

    }

}
