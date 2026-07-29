package com.biswasakashdev.swiftmart.accounts.controller.grpc;

import com.biswasakashdev.swiftmart.accounts.services.UserService;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.GetUserRequest;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.GetUserResponse;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.ReactorUserServiceGrpc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
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
                    log.info("User {} has been found", user.getId());
                    return GetUserResponse.newBuilder()
                            .setId(user.getId())
                            .setEmail(user.getEmail())
                            .setPhone(user.getPhone())
                            .setAvatar(user.getAvatar())
                            .setName(user.getName())
                            .setCountryCode(user.getCountryCode())
                            .setAvatar(user.getAvatar())
                            .build();
                });
    }


}
