package com.biswasakashdev.swiftmart.accounts.repository;

import com.biswasakashdev.swiftmart.accounts.models.User;

import reactor.core.publisher.Mono;


public interface UsersRepository {
    Mono<User> saveUser(User user);

    Mono<User> findByEmil(String email);

    Mono<User> findById(String id);
}
