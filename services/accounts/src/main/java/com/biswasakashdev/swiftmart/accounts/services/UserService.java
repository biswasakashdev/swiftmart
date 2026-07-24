package com.biswasakashdev.swiftmart.accounts.services;

import com.biswasakashdev.swiftmart.accounts.dtos.req.NewUserRequest;
import com.biswasakashdev.swiftmart.accounts.models.User;

import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> findUserById(String userId);

    Mono<User> findUserByEmail(String email);

    Mono<Void> createUser(NewUserRequest request);
}
