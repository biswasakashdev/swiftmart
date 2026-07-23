package com.biswasakashdev.swiftmart.gateway.dtos.inputs.catelogue;

import java.util.List;

public record CreateProductInput(
        String title,
        String description,
        String slug,
        List<CreateVariantInput> variants
) {
}
