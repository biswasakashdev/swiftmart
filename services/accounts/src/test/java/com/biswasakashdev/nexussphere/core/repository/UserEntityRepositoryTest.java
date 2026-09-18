package com.biswasakashdev.nexussphere.core.repository;

import java.time.LocalDate;

import com.biswasakashdev.swiftmart.accounts.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DuplicateKeyException;

import com.biswasakashdev.swiftmart.accounts.models.User;
import com.biswasakashdev.swiftmart.accounts.repository.impl.PostgresUserRepositoryImpl;
import com.biswasakashdev.swiftmart.accounts.repository.r2dbc.UsersR2DBCRepository;

import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


@Import(value = {
        PostgresUserRepositoryImpl.class,
        UsersR2DBCRepository.class,
        R2dbcEntityTemplate.class
})
class UserRepositoryTest extends AbstractRepositoryTest{

    @Autowired
    private UsersRepository usersRepository;

    private final String userEmail = "abc@gmail.com";
    private final User user = User.builder()
            .email(userEmail)
            .hashedPassword("password")
            .firstName("Jon")
            .lastName("Doe")
            .accountLocked(false)
            .createdOn(LocalDate.now())
            .build();


    @Test
    void shouldSaveUser() {
        usersRepository
                .saveUser(user)
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void shouldThrowUserAlreadyExistExceptionWhenTheEmailAlreadyExist() {

        usersRepository
                .saveUser(user)
                .then(usersRepository.saveUser(user))
                .as(StepVerifier::create)
                .expectError(DuplicateKeyException.class)
                .verify();
    }


    @Test
    void shouldReturnEmptyMonoIfUserNotFound() {
        Mono<User> usersMono = usersRepository.saveUser(user);

        usersMono
                .then(usersRepository.findByEmil(userEmail))
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();
    }


}