package com.biswasakashdev.swiftmart.gateway.dtos.models.products;


import java.math.BigDecimal;

public record ProductVariant(
        String id,
        String sku,
        BigDecimal price,
        Integer inventoryQuantity,
        Double weight,
        String title
) {}