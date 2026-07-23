package com.biswasakashdev.swiftmart.accounts.repository.r2dbc;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.biswasakashdev.swiftmart.accounts.models.User;

import reactor.core.publisher.Mono;

public interface UsersR2DBCRepository extends ReactiveCrudRepository<User, String> {

    Mono<User> findByEmailIgnoreCase(String email);

    Mono<Boolean> existsByEmailIgnoreCase(String email);
}
