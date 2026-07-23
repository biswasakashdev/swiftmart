package com.biswasakashdev.swiftmart.gateway.dtos.inputs.client;

public record CreateClientInp(
        String email,
        String countryCode,
        String phone,
        String password,
        String name
) {
}
