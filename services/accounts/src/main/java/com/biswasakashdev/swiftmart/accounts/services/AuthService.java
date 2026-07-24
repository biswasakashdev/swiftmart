package com.biswasakashdev.swiftmart.accounts.services;

import com.biswasakashdev.swiftmart.accounts.dtos.req.UserCredentials;
import com.biswasakashdev.swiftmart.accounts.models.User;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.AuthorizeRequest;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.AuthorizeResponse;

import reactor.core.publisher.Mono;

public interface AuthService {

    Mono<User> verify(UserCredentials credentials);

}
