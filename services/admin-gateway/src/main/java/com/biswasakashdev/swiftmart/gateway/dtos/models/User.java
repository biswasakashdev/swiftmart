package com.biswasakashdev.swiftmart.gateway.dtos.models;

import lombok.Builder;

@Builder
public record User(
        String id,
        String email,
        String name
) {
}
