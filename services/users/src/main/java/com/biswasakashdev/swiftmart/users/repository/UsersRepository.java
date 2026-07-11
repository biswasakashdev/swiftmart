package com.biswasakashdev.swiftmart.users.repository;

import com.biswasakashdev.swiftmart.users.models.User;

import reactor.core.publisher.Mono;


public interface UsersRepository {
    Mono<User> saveUser(User user);
}
