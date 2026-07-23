package com.biswasakashdev.swiftmart.accounts.services.impl;

import com.biswasakashdev.swiftmart.accounts.models.User;
import com.biswasakashdev.swiftmart.accounts.repository.UsersRepository;
import com.biswasakashdev.swiftmart.accounts.repository.r2dbc.UsersR2DBCRepository;
import com.biswasakashdev.swiftmart.accounts.services.UserService;
import com.biswasakashdev.swiftmart.protogen.accounts.v1.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
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
    public Mono<Void> createAccount(CreateUserRequest createAccountRequest) {
        User user = User.builder()
                .name(createAccountRequest.getName())
                .email(createAccountRequest.getEmail())
                .password(passwordEncoder.encode(createAccountRequest.getPassword()))
                .countryCode(createAccountRequest.getCountryCode())
                .contactNumber(createAccountRequest.getPhone())
                .accountLocked(false)
                .createdOn(LocalDate.now())
                .build();
        return usersRepository.saveUser(user).then();
    }

}
