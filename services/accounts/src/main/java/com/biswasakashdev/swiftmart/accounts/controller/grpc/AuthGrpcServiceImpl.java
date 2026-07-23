package com.biswasakashdev.swiftmart.accounts.controller.grpc;

import com.biswasakashdev.swiftmart.accounts.services.UserService;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.AuthorizeRequest;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.AuthorizeResponse;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.ReactorAuthServiceGrpc;
import org.springframework.stereotype.Component;

import com.biswasakashdev.swiftmart.accounts.services.AuthService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AuthGrpcServiceImpl extends ReactorAuthServiceGrpc.AuthServiceImplBase{

    private final AuthService authService;
    private final UserService userService;

    @Override
    public Mono<AuthorizeResponse> authorize(Mono<AuthorizeRequest> request) {
        return request
                .flatMap(authService::authorize);

    }
}
