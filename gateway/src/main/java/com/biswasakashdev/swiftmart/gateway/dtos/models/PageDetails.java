package com.biswasakashdev.swiftmart.gateway.dtos.models;

public record PageDetails(
        Integer page,
        Integer size,
        Long totalElements,
        Boolean isLast
) {
}
