package com.biswasakashdev.swiftmart.gateway.clients;

import com.biswasakashdev.swiftmart.protogen.accounts.v1.CreateUserRequest;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.CreateUserResponse;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.ReactorAccountServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
public class AccountsClient {

    private final ReactorAccountServiceGrpc.ReactorAccountServiceStub stub;

    public AccountsClient(Environment env) {
        String url = env.getProperty("grpc.server.accounts");

        if(Objects.isNull(url) || !url.isBlank()){
            throw new IllegalArgumentException("Accounts url not found");
        }

        stub = ReactorAccountServiceGrpc
                .newReactorStub(
                        ManagedChannelBuilder
                .forTarget(url)
                .usePlaintext()
                .build()
                );

    }

    public Mono<CreateUserResponse> createUser(){
        return stub.createUser(
                CreateUserRequest.newBuilder()
                        .build()
        );
    }


}
