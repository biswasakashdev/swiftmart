package com.biswasakashdev.swiftmart.accounts.utils;


import com.biswasakashdev.swiftmart.accounts.dtos.res.UserResponse;
import com.biswasakashdev.swiftmart.accounts.models.User;

public class UsersUtils {


    public static UserResponse getUserResponse(User user) {
        return new UserResponse(
                user.getEmail(),
                user.getName()
        );
    }
}
