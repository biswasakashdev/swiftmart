package com.biswasakashdev.swiftmart.users.services.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.biswasakashdev.swiftmart.users.models.User;
import com.biswasakashdev.swiftmart.users.services.UserService;

import reactor.core.publisher.Mono;

public class UserSeviceImpl implements UserService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
    }

    @Override
    public Mono<User> findUserById(String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findUserById'");
    }

}
