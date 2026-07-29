package com.biswasakashdev.nexussphere.core.repository;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DuplicateKeyException;

import com.biswasakashdev.swiftmart.accounts.models.User;
import com.biswasakashdev.swiftmart.accounts.repository.impl.PostgresUserRepositoryImpl;
import com.biswasakashdev.swiftmart.accounts.repository.r2dbc.UsersR2DBCRepository;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


@Import(value = {
        PostgresUserRepositoryImpl.class,
        UsersR2DBCRepository.class
})
class UserRepositoryTest extends AbstractRepositoryTest{

    @Autowired
    private UsersR2DBCRepository usersRepository;

    private final String userEmail = "abc@gmail.com";
    private final User user = User.builder()
            .email(userEmail)
            .password("password")
            .name("John Doe")
            .accountLocked(false)
            .createdOn(LocalDate.now())
            .build();


    @Test
    void shouldSaveUser() {
        usersRepository
                .save(user)
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void shouldThrowUserAlreadyExistExceptionWhenTheEmailAlreadyExist() {

        usersRepository
                .save(user)
                .then(usersRepository.save(user))
                .as(StepVerifier::create)
                .expectError(DuplicateKeyException.class)
                .verify();
    }


    @Test
    void shouldReturnEmptyMonoIfUserNotFound() {
        Mono<User> usersMono = usersRepository.save(user);

        usersMono
                .then(usersRepository.findByEmailIgnoreCase(userEmail))
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();
    }


}