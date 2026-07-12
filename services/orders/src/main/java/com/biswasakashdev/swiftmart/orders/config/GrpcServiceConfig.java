package com.biswasakashdev.swiftmart.orders.config;


import com.biswasakashdev.swiftmart.orders.controller.grpc.OrdersGrpcServiceImpl;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GrpcServiceConfig {

    private final OrdersGrpcServiceImpl ordersGrpcService;

    @Bean
    Server serverConfig(Environment environment){

        String grpcPort = environment.getProperty("grpc.server.port");

        if (grpcPort == null || grpcPort.isBlank()) {
            throw new IllegalArgumentException("Invalid gRPC port found");
        }

        return NettyServerBuilder
                .forPort(Integer.parseInt(grpcPort))
                .addService(ordersGrpcService)
                .build();

    }
}
