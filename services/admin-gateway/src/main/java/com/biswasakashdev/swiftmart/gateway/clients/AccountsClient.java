package com.biswasakashdev.swiftmart.gateway.clients;

import com.biswasakashdev.swiftmart.gateway.dtos.models.users.User;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.GetUserRequest;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.ReactorUserServiceGrpc;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AccountsClient {

    private final ReactorUserServiceGrpc.ReactorUserServiceStub userServiceStub;


    public AccountsClient(@Qualifier("accountsChannel") ManagedChannel channel) {
        userServiceStub = ReactorUserServiceGrpc.newReactorStub(channel);
    }


    public Mono<User> fetchUser(String userId){
        GetUserRequest request = GetUserRequest.newBuilder().setUserId(userId).build();

        return Mono
                .just(request)
                .transform(userServiceStub::getUser)
                .map(user-> User.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .countryCode(user.getCountryCode())
                        .phone(user.getPhone())
                        .id(user.getId())
                        .build());
    }


}
