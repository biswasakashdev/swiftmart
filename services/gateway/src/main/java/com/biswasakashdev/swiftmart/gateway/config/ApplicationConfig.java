package com.biswasakashdev.swiftmart.gateway.config;


import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Objects;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final Environment environment;

    @Bean
    ManagedChannel accountsChannel(){
        String url = environment.getProperty("grpc.server.accounts");

        if (Objects.isNull(url) || url.isBlank()) {
            throw new IllegalArgumentException("Accounts url not found");
        }
        return NettyChannelBuilder
                .forTarget(url)
                .usePlaintext()
                .build();
    }
}
