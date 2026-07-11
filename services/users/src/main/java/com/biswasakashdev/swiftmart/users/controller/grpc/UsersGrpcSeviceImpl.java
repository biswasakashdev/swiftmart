package com.biswasakashdev.swiftmart.users.controller.grpc;

import org.springframework.stereotype.Component;

import com.biswasakashdev.swiftmart.protogen.users.v1.AuthorizeRequest;
import com.biswasakashdev.swiftmart.protogen.users.v1.AuthorizeResponse;
import com.biswasakashdev.swiftmart.protogen.users.v1.CreateAccountRequest;
import com.biswasakashdev.swiftmart.protogen.users.v1.CreateAccountResponse;
import com.biswasakashdev.swiftmart.protogen.users.v1.ReactorUsersServiceGrpc;

import reactor.core.publisher.Mono;

@Component
public class UsersGrpcSeviceImpl extends ReactorUsersServiceGrpc.UsersServiceImplBase {

    @Override
    public Mono<AuthorizeResponse> authorize(Mono<AuthorizeRequest> request) {
        // TODO Auto-generated method stub
        return super.authorize(request);
    }

    @Override
    public Mono<CreateAccountResponse> createAccount(Mono<CreateAccountRequest> request) {
        // TODO Auto-generated method stub
        return super.createAccount(request);
    }

}
