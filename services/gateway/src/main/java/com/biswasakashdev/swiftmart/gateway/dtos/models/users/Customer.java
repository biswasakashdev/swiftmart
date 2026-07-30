package com.biswasakashdev.swiftmart.gateway.dtos.models.users;


import com.biswasakashdev.swiftmart.gateway.dtos.models.order.Order;

import java.time.LocalDateTime;
import java.util.List;

public record Customer(
        String id,
        String email,
        String firstName,
        String lastName,
        List<Order> orders,
        LocalDateTime createdAt
) {}
