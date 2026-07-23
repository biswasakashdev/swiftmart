package com.biswasakashdev.swiftmart.accounts.controller.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class Heath {

    @GetMapping("/healthz")
    public Mono<Map<String,String>> health(){
        return Mono.just(Map.of("status","ok"));
    }
}
