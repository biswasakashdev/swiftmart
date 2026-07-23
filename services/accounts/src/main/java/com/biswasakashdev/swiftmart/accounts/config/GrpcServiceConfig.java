package com.biswasakashdev.swiftmart.accounts.config;

import com.biswasakashdev.swiftmart.accounts.controller.grpc.UserGrpcServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.biswasakashdev.swiftmart.accounts.controller.grpc.AuthGrpcServiceImpl;

import io.grpc.Server;
import lombok.RequiredArgsConstructor;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;

@Configuration
@RequiredArgsConstructor
public class GrpcServiceConfig {

    private final AuthGrpcServiceImpl authGrpcServiceImpl;
    private final UserGrpcServiceImpl userGrpcServiceImpl;

    @Bean
    Server grpcServer(Environment environment) {
        String grpcPort = environment.getProperty("grpc.server.port");

        if (grpcPort == null || grpcPort.isBlank()) {
            throw new IllegalArgumentException("Invalid gRPC port found");
        }

        return NettyServerBuilder
                .forPort(Integer.parseInt(grpcPort))
                .addService(authGrpcServiceImpl)
                .addService(userGrpcServiceImpl)
                .build();
    }

}
