package com.biswasakashdev.swiftmart.accounts.services;

import com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountRequest;
import com.biswasakashdev.swiftmart.protogen.core.v1.CreateAccountResponse;
import com.biswasakashdev.swiftmart.accounts.models.User;

import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> findUserById(String userId);

    Mono<User> findUserByEmail(String email);

    Mono<CreateAccountResponse> createAccount(CreateAccountRequest createAccountRequest);
}
