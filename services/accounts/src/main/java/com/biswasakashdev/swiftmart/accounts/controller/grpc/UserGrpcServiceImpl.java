package com.biswasakashdev.swiftmart.accounts.controller.grpc;

import org.springframework.stereotype.Component;

import com.biswasakashdev.swiftmart.accounts.services.UserService;
import com.biswasakashdev.swiftmart.accounts.utils.UsersMapper;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.GetUserRequest;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.GetUserResponse;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.ReactorUserServiceGrpc;
import com.biswasakashdev.swiftmart.protogen.types.accounts.v1.UsersProto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

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
                    UsersProto usersProto = UsersMapper.mapToUserProto(user);
                    return GetUserResponse.newBuilder()
                            .setUser(usersProto)
                            .build();
                });
    }

}
