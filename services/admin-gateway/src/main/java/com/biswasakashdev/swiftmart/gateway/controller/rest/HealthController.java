package com.biswasakashdev.swiftmart.gateway.controller.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class HealthController {


    @GetMapping("/healtz")
    public Mono<Map<String,String>> health() {
        return Mono.just(Map.of("status", "OK"));
    }
}
