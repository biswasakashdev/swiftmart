package com.biswasakashdev.swiftmart.core.config;

import java.io.IOException;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import io.grpc.Server;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class GrpcServerConfigurer {

    private final Server grpcServer;

    @EventListener(ApplicationReadyEvent.class)
    void onStartApplication() throws IOException {
        grpcServer.start();
        log.info("gRPC server started on port: {}", grpcServer.getPort());
    }

}
