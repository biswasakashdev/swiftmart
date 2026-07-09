package com.biswasakashdev.swiftmart.users.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.biswasakashdev.swiftmart.users.models.User;

import reactor.core.publisher.Mono;

public interface UserService extends UserDetailsService {

    Mono<User> findUserById(String userId);

}
