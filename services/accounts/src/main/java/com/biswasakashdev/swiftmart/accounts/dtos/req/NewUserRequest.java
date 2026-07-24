package com.biswasakashdev.swiftmart.accounts.dtos.req;

public record NewUserRequest(
        String email,
        String password,
        String countryCode,
        String phone,
        String name
) {
}
