package com.biswasakashdev.swiftmart.accounts.services.impl;

import com.biswasakashdev.swiftmart.protogen.accounts.v1.AuthorizeRequest;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.AuthorizeResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biswasakashdev.swiftmart.accounts.services.AuthService;
import com.biswasakashdev.swiftmart.accounts.services.JwtService;
import com.biswasakashdev.swiftmart.accounts.services.UserService;

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
                .findUserByEmail(request.getEmailOrPhone())
                .map(fetchedUser -> {
                    boolean isPasswordMatch = passwordEncoder.matches(request.getPassword(), fetchedUser.getPassword());
                    if (!isPasswordMatch) {
                        throw new BadCredentialsException("Invalid credentials found");
                    }


                    AuthorizeResponse.User userResponse= AuthorizeResponse.User.newBuilder()
                            .setName(fetchedUser.getName())
                            .setEmail(fetchedUser.getEmail())
                            .build();

                    String token = jwtService.buildToken(fetchedUser.getId(), Duration.ofDays(1),new HashMap<>());

                    return AuthorizeResponse.newBuilder()
                            .setToken(token)
                            .setUser(userResponse)
                            .build();
                });

    }

}
