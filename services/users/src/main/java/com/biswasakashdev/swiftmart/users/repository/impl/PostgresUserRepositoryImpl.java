package com.biswasakashdev.swiftmart.users.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;

import com.biswasakashdev.swiftmart.users.models.User;
import com.biswasakashdev.swiftmart.users.repository.UsersRepository;
import com.biswasakashdev.swiftmart.users.repository.r2dbc.UsersR2DBCRepository;

import reactor.core.publisher.Mono;

import java.util.UUID;


@Repository
@RequiredArgsConstructor
public class PostgresUserRepositoryImpl implements UsersRepository {

    private final DatabaseClient databaseClient;
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
