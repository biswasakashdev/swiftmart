package com.biswasakashdev.swiftmart.accounts.dtos.res;


public record SessionDetails(
        String token,
        long maxAge // Token valid in seconds.
) {
}
