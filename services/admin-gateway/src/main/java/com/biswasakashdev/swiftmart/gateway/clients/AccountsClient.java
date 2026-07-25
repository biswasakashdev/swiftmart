package com.biswasakashdev.swiftmart.gateway.clients;

import com.biswasakashdev.swiftmart.protogen.accounts.v1.ReactorUserServiceGrpc;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AccountsClient {

    private final ReactorUserServiceGrpc.ReactorUserServiceStub userServiceStub;


    public AccountsClient(@Qualifier("accountsChannel") ManagedChannel channel) {
        userServiceStub = ReactorUserServiceGrpc.newReactorStub(channel);
    }





}
