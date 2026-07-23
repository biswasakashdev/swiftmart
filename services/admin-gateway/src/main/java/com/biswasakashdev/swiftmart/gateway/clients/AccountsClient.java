package com.biswasakashdev.swiftmart.gateway.clients;

import com.biswasakashdev.swiftmart.gateway.dtos.inputs.CredentialsInp;
import com.biswasakashdev.swiftmart.gateway.dtos.inputs.users.CreateUserInp;
import com.biswasakashdev.swiftmart.gateway.dtos.models.Authorization;
import com.biswasakashdev.swiftmart.gateway.dtos.models.User;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
public class AccountsClient {

    private final ReactorAuthServiceGrpc.ReactorAuthServiceStub authServiceStub;
    private final ReactorUserServiceGrpc.ReactorUserServiceStub userServiceStub;


    public AccountsClient(Environment env) {
        String url = env.getProperty("grpc.server.accounts");

        if (Objects.isNull(url) || url.isBlank()) {
            throw new IllegalArgumentException("Accounts url not found");
        }


        ManagedChannel accountsChannel = ManagedChannelBuilder
                .forTarget(url)
                .usePlaintext()
                .build();

        authServiceStub = ReactorAuthServiceGrpc.newReactorStub(accountsChannel);
        userServiceStub = ReactorUserServiceGrpc.newReactorStub(accountsChannel);

    }

    public Mono<Void> createUser(CreateUserInp createUserInp) {
        Mono<CreateUserRequest> req = Mono.just(CreateUserRequest.newBuilder()
                .setName(createUserInp.name())
                .setEmail(createUserInp.email())
                .setCountryCode(createUserInp.countryCode())
                .setPassword(createUserInp.password())
                .setPhone(createUserInp.phone())
                .build());
        return req
                .transform(userServiceStub::createUser)
                .then();

    }

    public Mono<Authorization> authorize(CredentialsInp credentials) {
        return authServiceStub.authorize(
                        AuthorizeRequest.newBuilder()
                                .setEmailOrPhone(credentials.emailOrPhone())
                                .setPassword(credentials.password())
                                .setRememberMe(true)
                                .build()
                )
                .map(authorizeResponse -> {

                    AuthorizeResponse.User authorizeUser = authorizeResponse.getUser();
                    User user = User.builder()
                            .id("a-long-id")
                            .email(authorizeUser.getEmail())
                            .name(authorizeUser.getName())
                            .build();


                    return new Authorization(
                            authorizeResponse.getToken(),
                            user
                    );
                });
    }


}
