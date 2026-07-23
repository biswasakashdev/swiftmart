package com.biswasakashdev.swiftmart.gateway.dtos.models;

public record Authorization(
        String token,
        User user
) {
}
