package com.biswasakashdev.swiftmart.accounts.controller.grpc;


import org.springframework.stereotype.Component;

import com.biswasakashdev.swiftmart.accounts.exception.DatabaseOperationException;
import com.biswasakashdev.swiftmart.accounts.services.UserService;
import com.biswasakashdev.swiftmart.accounts.utils.UsersMapper;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.CreateUserRequest;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.CreateUserResponse;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.ReactorAuthServiceGrpc;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.VerifyRequest;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.VerifyResponse;
import com.biswasakashdev.swiftmart.protogen.types.accounts.v1.UsersProto;

import io.grpc.Status;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@Component 
@RequiredArgsConstructor 
public class AuthGrpcServiceImpl extends ReactorAuthServiceGrpc.AuthServiceImplBase{


    private final UserService userService;


    @Override
    public Mono<CreateUserResponse> createUser(Mono<CreateUserRequest> request) {
        return request.flatMap(userService::createUser)
                .map(savedUser->{
                    UsersProto usersProto = UsersMapper.mapToUserProto(savedUser);
                    return CreateUserResponse.newBuilder()
                            .setUser(usersProto)
                            .build();
                })
                .onErrorMap(DatabaseOperationException.class, ex-> Status.INTERNAL
                        .withDescription(ex.getMessage())
                        .asRuntimeException());
    }





    @Override
    public Mono<VerifyResponse> verify(Mono<VerifyRequest> request) {
        return request.flatMap(userService::verifyCredentials)
                .map(user -> {

                    UsersProto usersProto = UsersMapper.mapToUserProto(user);
                   return VerifyResponse.newBuilder()
                           .setUser(usersProto)
                           .build();
                });
    }

 


}
