package com.biswasakashdev.swiftmart.core.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Repository;

import com.biswasakashdev.swiftmart.core.models.User;
import com.biswasakashdev.swiftmart.core.repository.UsersRepository;
import com.biswasakashdev.swiftmart.core.repository.r2dbc.UsersR2DBCRepository;

import reactor.core.publisher.Mono;

import java.util.UUID;


@Repository
@RequiredArgsConstructor
public class PostgresUserRepositoryImpl implements UsersRepository {

    private final UsersR2DBCRepository usersR2DBCRepository;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;

    @Override
    public Mono<User> saveUser(User user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        return r2dbcEntityTemplate
                .insert(User.class)
                .using(user);
    }

}
