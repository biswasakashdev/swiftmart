package com.biswasakashdev.swiftmart.accounts.services.impl;

import com.biswasakashdev.swiftmart.accounts.dtos.req.UserCredentials;
import com.biswasakashdev.swiftmart.accounts.models.User;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biswasakashdev.swiftmart.accounts.services.AuthService;
import com.biswasakashdev.swiftmart.accounts.services.UserService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Mono<User> verify(UserCredentials credentials) {

        return userService
                .findUserByEmail(credentials.email())
                .handle((fetchedUser, sink) -> {
                    boolean isPasswordMatch = passwordEncoder.matches(credentials.password(), fetchedUser.getPassword());
                    if (!isPasswordMatch) {
                        sink.error(new BadCredentialsException("Invalid credentials found"));
                        return;
                    }

                    sink.next(fetchedUser);
                });
    }

}
