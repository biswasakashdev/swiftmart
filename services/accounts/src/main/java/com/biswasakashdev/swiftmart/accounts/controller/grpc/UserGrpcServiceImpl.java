package com.biswasakashdev.swiftmart.accounts.controller.grpc;

import com.biswasakashdev.swiftmart.accounts.dtos.req.NewUserRequest;
import com.biswasakashdev.swiftmart.accounts.services.UserService;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.CreateUserRequest;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.CreateUserResponse;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.ReactorUserServiceGrpc;
import com.google.protobuf.Empty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserGrpcServiceImpl extends ReactorUserServiceGrpc.UserServiceImplBase {

    private final UserService userService;
    
}
