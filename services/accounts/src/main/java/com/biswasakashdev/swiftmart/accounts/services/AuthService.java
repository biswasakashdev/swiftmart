package com.biswasakashdev.swiftmart.accounts.services;

import com.biswasakashdev.swiftmart.accounts.dtos.req.UserCredentials;
import com.biswasakashdev.swiftmart.accounts.models.User;

import reactor.core.publisher.Mono;

public interface AuthService {

    Mono<User> verify(UserCredentials credentials);

}
