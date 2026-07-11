package com.biswasakashdev.swiftmart.users.controller.grpc;

import com.biswasakashdev.swiftmart.users.services.UserService;
import org.springframework.stereotype.Component;

import com.biswasakashdev.swiftmart.protogen.users.v1.AuthorizeRequest;
import com.biswasakashdev.swiftmart.protogen.users.v1.AuthorizeResponse;
import com.biswasakashdev.swiftmart.protogen.users.v1.CreateAccountRequest;
import com.biswasakashdev.swiftmart.protogen.users.v1.CreateAccountResponse;
import com.biswasakashdev.swiftmart.protogen.users.v1.ReactorUsersServiceGrpc;
import com.biswasakashdev.swiftmart.users.services.AuthService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UsersGrpcServiceImpl extends ReactorUsersServiceGrpc.UsersServiceImplBase {

    private final AuthService authService;
    private final UserService userService;

    @Override
    public Mono<AuthorizeResponse> authorize(Mono<AuthorizeRequest> request) {
        return request.flatMap(authService::authorize);
    }

    @Override
    public Mono<CreateAccountResponse> createAccount(Mono<CreateAccountRequest> request) {
        return request.flatMap(userService::createAccount);
    }

}
