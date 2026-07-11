package com.biswasakashdev.swiftmart.users.services;

import com.biswasakashdev.swiftmart.protogen.users.v1.AuthorizeRequest;
import com.biswasakashdev.swiftmart.protogen.users.v1.AuthorizeResponse;

import reactor.core.publisher.Mono;

public interface AuthService {

    Mono<AuthorizeResponse> authorize(AuthorizeRequest request);

}
