package com.biswasakashdev.swiftmart.users.services.impl;

import com.biswasakashdev.swiftmart.protogen.users.v1.CreateAccountRequest;
import com.biswasakashdev.swiftmart.protogen.users.v1.CreateAccountResponse;
import com.biswasakashdev.swiftmart.users.repository.UsersRepository;
import com.biswasakashdev.swiftmart.users.repository.r2dbc.UsersR2DBCRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biswasakashdev.swiftmart.users.models.User;
import com.biswasakashdev.swiftmart.users.services.UserService;

import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UsersRepository usersRepository;
    private final UsersR2DBCRepository usersR2DBCRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Mono<User> findUserById(String userId) {
        return usersR2DBCRepository.findById(userId);
    }

    @Override
    public Mono<User> findUserByEmail(String email) {
        return usersR2DBCRepository.findByEmailIgnoreCase(email);
    }

    @Override
    public Mono<CreateAccountResponse> createAccount(CreateAccountRequest createAccountRequest) {
        User user = User.builder()
                .firstName(createAccountRequest.getFirstName())
                .lastName(createAccountRequest.getLastName())
                .email(createAccountRequest.getEmail())
                .password(passwordEncoder.encode(createAccountRequest.getPassword()))
                .countryCode(createAccountRequest.getCountryCode())
                .contactNumber(createAccountRequest.getContactNumber())
                .accountLocked(false)
                .createdOn(LocalDate.now())
                .build();
        return usersRepository.saveUser(user)
                .then(Mono.just(CreateAccountResponse.newBuilder().build()));
    }

}
