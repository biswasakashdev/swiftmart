package com.biswasakashdev.swiftmart.accounts.controller.grpc;

import com.biswasakashdev.swiftmart.accounts.exception.DatabaseOperationException;
import com.biswasakashdev.swiftmart.accounts.models.User;
import com.biswasakashdev.swiftmart.accounts.services.UserService;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.*;
import com.biswasakashdev.swiftmart.protogen.prototypes.v1.UsersProto;
import io.grpc.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserGrpcServiceImpl extends ReactorUserServiceGrpc.UserServiceImplBase{

    private final UserService userService;

    @Override
    public Mono<GetUserResponse> getUser(Mono<GetUserRequest> request) {
        return request
                .flatMap(req-> userService.findUserById(req.getUserId()))
                .map(user -> {
                    UsersProto usersProto =mapToUserProto(user);
                    return GetUserResponse.newBuilder()
                            .setUser(usersProto)
                            .build();
                });
    }

    @Override
    public Mono<CreateUserResponse> createUser(Mono<CreateUserRequest> request) {
        return request.flatMap(userService::createUser)
                .map(savedUser->{
                    UsersProto usersProto = mapToUserProto(savedUser);
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

                    UsersProto usersProto = mapToUserProto(user);
                   return VerifyResponse.newBuilder()
                           .setUser(usersProto)
                           .build();
                });
    }

    private UsersProto mapToUserProto(User user) {

        UsersProto.Builder userProtoBuilder = UsersProto.newBuilder()
                .setId(user.getId())
                .setEmail(user.getEmail())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setAccountEnabled(user.getAccountLocked())
                .setCreatedAt(user.getCreatedOn().toString());

        if (user.getAvatar() != null){
            userProtoBuilder  = userProtoBuilder.setAvatar(user.getAvatar());
        }
        return userProtoBuilder.build();

    }
}
