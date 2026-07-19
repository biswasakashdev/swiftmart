package com.biswasakashdev.swiftmart.gateway.dtos.inputs;

import java.math.BigDecimal;
import java.util.List;

public record CreateProductInput(
        String title,
        String description,
        String slug,
        List<CreateVariantInput> variants
) {
}
