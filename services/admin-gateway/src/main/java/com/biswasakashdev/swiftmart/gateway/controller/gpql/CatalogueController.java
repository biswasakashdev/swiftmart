package com.biswasakashdev.swiftmart.gateway.controller.gpql;


import com.biswasakashdev.swiftmart.gateway.dtos.inputs.catelogue.CreateProductInput;
import com.biswasakashdev.swiftmart.gateway.dtos.inputs.PageInfo;
import com.biswasakashdev.swiftmart.gateway.dtos.models.Page;
import com.biswasakashdev.swiftmart.gateway.dtos.models.PageDetails;
import com.biswasakashdev.swiftmart.gateway.dtos.models.catelogues.Product;
import com.biswasakashdev.swiftmart.gateway.dtos.models.catelogues.ProductStatus;
import com.biswasakashdev.swiftmart.gateway.dtos.models.catelogues.ProductVariant;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class CatalogueController {


    @QueryMapping
    public Product product(
            @Argument String shopId,
            @Argument String id
    ) {
        // Example stub: fetch product by id
        return new Product(
                id,
                "Sample Product",
                "Demo description",
                "sample-product",
                ProductStatus.ACTIVE,
                List.of(
                        new ProductVariant("", "SKU-001", BigDecimal.valueOf(99.99), 50, 1.2, "Variant A")
                ),
                java.time.LocalDateTime.now(),
                java.time.LocalDateTime.now()
        );
    }

    @QueryMapping
    public Page<Product> products(@Argument String shopId, @Argument PageInfo pageInfo, @Argument String query) {
        // Example stub: return list of products
        PageDetails pageDetails = new PageDetails(
                1,
                10,
                12L,
                false
        );
        return new Page<>(
                pageDetails,
                List.of(
                        new Product(
                                "a-long-id",
                                "Sample Product",
                                "Demo description",
                                "sample-product",
                                ProductStatus.ACTIVE,
                                List.of(
                                        new ProductVariant("", "SKU-001", BigDecimal.valueOf(99.99), 50, 1.2, "Variant A")
                                ),
                                java.time.LocalDateTime.now(),
                                java.time.LocalDateTime.now()
                        )
                )
        );
    }


    @MutationMapping
    public Product createProduct(@Argument CreateProductInput input) {
        return new Product(
                "a-long-id",
                "Sample Product",
                "Demo description",
                "sample-product",
                ProductStatus.ACTIVE,
                List.of(
                        new ProductVariant("", "SKU-001", BigDecimal.valueOf(99.99), 50, 1.2, "Variant A")
                ),
                java.time.LocalDateTime.now(),
                java.time.LocalDateTime.now()
        );
    }

    @MutationMapping
    public ProductVariant updateStock(
            @Argument String shopId,
            @Argument String variantId,
            @Argument Integer quantityDelta
    ) {
        return new ProductVariant(
                "",
                "",
                BigDecimal.valueOf(12.8),
                1,
                null,
                "White color blue"
        );
    }


}
