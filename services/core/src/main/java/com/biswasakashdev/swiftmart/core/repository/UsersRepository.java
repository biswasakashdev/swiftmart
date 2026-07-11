package com.biswasakashdev.swiftmart.core.repository;

import com.biswasakashdev.swiftmart.core.models.User;

import reactor.core.publisher.Mono;


public interface UsersRepository {
    Mono<User> saveUser(User user);
}
