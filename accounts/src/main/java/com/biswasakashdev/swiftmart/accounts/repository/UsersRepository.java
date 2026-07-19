package com.biswasakashdev.swiftmart.accounts.repository;

import com.biswasakashdev.swiftmart.accounts.models.User;

import reactor.core.publisher.Mono;


public interface UsersRepository {
    Mono<User> saveUser(User user);
}
