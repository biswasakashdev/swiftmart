package com.biswasakashdev.swiftmart.gateway.dtos.models.order;

public record LineItem(
        Long id,
        Long variantId,
        String title,
        Integer quantity,
        Double price
) {}
