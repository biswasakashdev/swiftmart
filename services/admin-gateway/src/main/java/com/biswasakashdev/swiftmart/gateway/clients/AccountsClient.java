package com.biswasakashdev.swiftmart.gateway.clients;

import com.biswasakashdev.swiftmart.gateway.dtos.inputs.CredentialsInp;
import com.biswasakashdev.swiftmart.gateway.dtos.inputs.users.CreateUserInp;
import com.biswasakashdev.swiftmart.gateway.dtos.models.Authorization;
import com.biswasakashdev.swiftmart.gateway.dtos.models.User;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
public class AccountsClient {

    private final ReactorUserServiceGrpc.ReactorUserServiceStub userServiceStub;


    public AccountsClient(@Qualifier("accountsChannel") ManagedChannel channel) {
        userServiceStub = ReactorUserServiceGrpc.newReactorStub(channel);
    }



}
