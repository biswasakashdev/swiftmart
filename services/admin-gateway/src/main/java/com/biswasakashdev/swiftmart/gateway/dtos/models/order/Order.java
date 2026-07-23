package com.biswasakashdev.swiftmart.gateway.dtos.models.order;



import com.biswasakashdev.swiftmart.gateway.dtos.models.Customer;

import java.time.LocalDateTime;
import java.util.List;

public record Order(
        String id,
        Customer customer,
        List<LineItem> lineItems,
        Double totalPrice,
        OrderFinancialStatus financialStatus,
        OrderFulfillmentStatus fulfillmentStatus,
        LocalDateTime createdAt
) {}