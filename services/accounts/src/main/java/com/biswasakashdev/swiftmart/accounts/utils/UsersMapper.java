package com.biswasakashdev.swiftmart.accounts.utils;


import com.biswasakashdev.swiftmart.accounts.models.User;
import com.biswasakashdev.swiftmart.protogen.types.accounts.v1.UsersProto;

public class UsersMapper {

   public static UsersProto mapToUserProto(User user) {

        UsersProto.Builder userProtoBuilder = UsersProto.newBuilder()
                .setId(user.getId())
                .setEmail(user.getEmail())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setAccountEnabled(user.getAccountLocked())
                .setCreatedAt(user.getCreatedOn().toString());

        if (user.getAvatar() != null){
            userProtoBuilder  = userProtoBuilder.setAvatar(user.getAvatar());
        }
        return userProtoBuilder.build();

    }
}
