package com.biswasakashdev.swiftmart.users.services;

import com.biswasakashdev.swiftmart.protogen.users.v1.CreateAccountRequest;
import com.biswasakashdev.swiftmart.protogen.users.v1.CreateAccountResponse;
import com.biswasakashdev.swiftmart.users.models.User;

import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> findUserById(String userId);

    Mono<User> findUserByEmail(String email);

    Mono<CreateAccountResponse> createAccount(CreateAccountRequest createAccountRequest);
}
