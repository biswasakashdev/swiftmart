package com.biswasakashdev.swiftmart.accounts.services;

import com.biswasakashdev.swiftmart.accounts.models.User;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.CreateUserRequest;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.VerifyRequest;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> findUserById(String userId);

    Mono<User> findUserByEmail(String email);

    Mono<User> createUser(CreateUserRequest request);

    Mono<User> verifyCredentials(VerifyRequest request);
}
