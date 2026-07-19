package com.biswasakashdev.swiftmart.gateway.dtos.models.products;

import com.biswasakashdev.swiftmart.gateway.dtos.models.PageDetails;

import java.util.List;

public record ProductList(
        PageDetails pageDetails,
        List<Product> content
) {
}
