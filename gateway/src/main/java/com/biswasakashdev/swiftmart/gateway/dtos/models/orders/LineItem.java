package com.biswasakashdev.swiftmart.gateway.dtos.models.orders;

public record LineItem(
        Long id,
        Long variantId,
        String title,
        Integer quantity,
        Double price
) {}
