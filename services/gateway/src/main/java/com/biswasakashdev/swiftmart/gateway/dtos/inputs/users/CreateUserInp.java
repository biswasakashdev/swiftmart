package com.biswasakashdev.swiftmart.gateway.dtos.inputs.users;

public record CreateUserInp(
        String email,
        String countryCode,
        String phone,
        String password,
        String name
) {
}
