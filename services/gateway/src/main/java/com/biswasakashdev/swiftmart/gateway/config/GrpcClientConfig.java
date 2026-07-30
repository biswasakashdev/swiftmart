package com.biswasakashdev.swiftmart.gateway.config;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GrpcClientConfig {

    private final ApplicationConfig applicationConfig;

    @Bean
    ManagedChannel accountsChannel() {
        return NettyChannelBuilder
                .forTarget(applicationConfig.accountsGrpc())
                .usePlaintext()
                .build();
    }

}
