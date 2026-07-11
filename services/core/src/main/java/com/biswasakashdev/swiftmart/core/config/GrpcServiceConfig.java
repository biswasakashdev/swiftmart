package com.biswasakashdev.swiftmart.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.biswasakashdev.swiftmart.core.controller.grpc.UsersGrpcServiceImpl;

import io.grpc.Server;
import lombok.RequiredArgsConstructor;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;

@Configuration
@RequiredArgsConstructor
public class GrpcServiceConfig {

    private final UsersGrpcServiceImpl usersGrpcServiceImpl;

    @Bean
    Server grpcServer(Environment environment) {
        String grpcPort = environment.getProperty("grpc.server.port");

        if (grpcPort == null || grpcPort.isBlank()) {
            throw new IllegalArgumentException("Invalid gRPC port found");
        }

        return NettyServerBuilder
                .forPort(Integer.parseInt(grpcPort))
                .addService(usersGrpcServiceImpl)
                .build();
    }

}
