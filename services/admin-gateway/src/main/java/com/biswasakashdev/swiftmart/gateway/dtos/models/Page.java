package com.biswasakashdev.swiftmart.gateway.dtos.models;

import java.util.List;

public record Page<T>(
        PageDetails pageDetails,
        List<T> content
) {
}
