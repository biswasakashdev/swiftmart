package com.biswasakashdev.swiftmart.accounts.dtos.res;



public record Authorization(
        String token,
        UserResponse user
) {
}