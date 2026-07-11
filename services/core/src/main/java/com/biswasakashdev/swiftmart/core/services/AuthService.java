package com.biswasakashdev.swiftmart.core.services;

import com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeRequest;
import com.biswasakashdev.swiftmart.protogen.core.v1.AuthorizeResponse;

import reactor.core.publisher.Mono;

public interface AuthService {

    Mono<AuthorizeResponse> authorize(AuthorizeRequest request);

}
