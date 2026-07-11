package com.biswasakashdev.swiftmart.core.repository.r2dbc;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.biswasakashdev.swiftmart.core.models.User;

import reactor.core.publisher.Mono;

public interface UsersR2DBCRepository extends ReactiveCrudRepository<User, String> {

    Mono<User> findByEmailIgnoreCase(String email);

    Mono<Boolean> existsByEmailIgnoreCase(String email);
}
