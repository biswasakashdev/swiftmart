package com.biswasakashdev.swiftmart.gateway.dtos.models.products;


import java.time.LocalDateTime;
import java.util.List;

public record Product(
        String id,
        String title,
        String description,
        String slug,
        ProductStatus status,
        List<ProductVariant> variants,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
