package com.biswasakashdev.swiftmart.gateway.dtos.models.order;

import com.biswasakashdev.swiftmart.gateway.dtos.models.PageDetails;

import java.util.List;

public record OrderList(
        PageDetails pageDetails,
        List<Order> content
) {
}
