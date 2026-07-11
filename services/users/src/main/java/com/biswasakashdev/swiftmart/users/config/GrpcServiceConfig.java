package com.biswasakashdev.swiftmart.users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.biswasakashdev.swiftmart.users.controller.grpc.UsersGrpcSeviceImpl;

import io.grpc.Server;
import lombok.RequiredArgsConstructor;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;

@Configuration
@RequiredArgsConstructor
public class GrpcServiceConfig {

    private final UsersGrpcSeviceImpl usersGrpcSeviceImpl;

    @Bean
    Server grpcServer(Environment environment) {
        int grpcPort = environment.getProperty("grpc.server.port", Integer.class);

        return NettyServerBuilder
                .forPort(grpcPort)
                .addService(usersGrpcSeviceImpl)
                .build();
    }

}
