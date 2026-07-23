package com.biswasakashdev.swiftmart.gateway.dtos.inputs;

public record CredentialsInput(
        String emailOrPhone,
        String password
) {
}
