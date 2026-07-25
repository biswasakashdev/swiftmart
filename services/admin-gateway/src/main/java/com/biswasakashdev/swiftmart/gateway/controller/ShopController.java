package com.biswasakashdev.swiftmart.gateway.controller;


import com.biswasakashdev.swiftmart.gateway.dtos.inputs.PageInfo;
import com.biswasakashdev.swiftmart.gateway.dtos.models.Page;
import com.biswasakashdev.swiftmart.gateway.dtos.models.PageDetails;
import com.biswasakashdev.swiftmart.gateway.dtos.models.shop.Shop;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class ShopController {

    @QueryMapping
    public Mono<Page<Shop>> shops(@Argument PageInfo pageInfo, @RequestHeader String userId){

        PageDetails pageDetails = new PageDetails(
                1,
                10,
                12L,
                false
        );
        return Mono.just(new Page<>(
                pageDetails,
                List.of()
        ));
    }
}

