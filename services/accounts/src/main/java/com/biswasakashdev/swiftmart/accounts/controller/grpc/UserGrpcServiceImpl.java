package com.biswasakashdev.swiftmart.accounts.controller.grpc;

import com.biswasakashdev.swiftmart.accounts.services.UserService;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.GetUserRequest;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.GetUserResponse;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.ReactorUserServiceGrpc;
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
                    log.info("User {} has been found", user);
                    GetUserResponse.Builder resBuilder = GetUserResponse.newBuilder()
                            .setId(user.getId())
                            .setEmail(user.getEmail())
                            .setPhone(user.getPhone())
                            .setName(user.getName())
                            .setCountryCode(user.getCountryCode());

                    if(Objects.isNull(user.getAvatar())){
                        return resBuilder.build();
                    }
                    return resBuilder.setAvatar(user.getAvatar()).build();
                });
    }


}
