package com.biswasakashdev.swiftmart.gateway.dtos.inputs;


import java.math.BigDecimal;

public record CreateVariantInput(
        String sku,
        BigDecimal price,
        Integer inventoryQuantity,
        String title
) {
}