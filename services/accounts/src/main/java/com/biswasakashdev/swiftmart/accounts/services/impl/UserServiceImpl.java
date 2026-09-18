package com.biswasakashdev.swiftmart.accounts.services.impl;

import com.biswasakashdev.swiftmart.accounts.exception.InvalidCredentialException;
import com.biswasakashdev.swiftmart.accounts.models.User;
import com.biswasakashdev.swiftmart.accounts.repository.UsersRepository;
import com.biswasakashdev.swiftmart.accounts.services.UserService;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.CreateUserRequest;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.VerifyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Mono<User> findUserById(String userId) {
        return usersRepository.findById(userId);
    }

    @Override
    public Mono<User> findUserByEmail(String email) {
        return usersRepository.findByEmil(email);
    }

    @Override
    public Mono<User> createUser(CreateUserRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .hashedPassword(passwordEncoder.encode(request.getPassword()))
                .accountLocked(false)
                .createdOn(LocalDate.now())
                .build();
        return usersRepository
                .saveUser(user);
    }

    @Override
    public Mono<User> verifyCredentials(VerifyRequest request) {
        return usersRepository.findByEmil(request.getEmail())
                .switchIfEmpty(Mono.error(new InvalidCredentialException("Invalid email")))
                .flatMap(user->{
                    String hashedPassword = user.getHashedPassword();

                    if (!passwordEncoder.matches(request.getPassword(), hashedPassword)) {
                        return Mono.error(new InvalidCredentialException("Invalid username and password"));
                    }
                    return Mono.just(user);
                });
    }

}
