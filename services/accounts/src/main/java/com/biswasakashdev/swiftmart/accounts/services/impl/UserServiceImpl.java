package com.biswasakashdev.swiftmart.accounts.services.impl;

import com.biswasakashdev.swiftmart.accounts.dtos.req.NewUserRequest;
import com.biswasakashdev.swiftmart.accounts.models.User;
import com.biswasakashdev.swiftmart.accounts.repository.UsersRepository;
import com.biswasakashdev.swiftmart.accounts.repository.r2dbc.UsersR2DBCRepository;
import com.biswasakashdev.swiftmart.accounts.services.UserService;
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
    public Mono<Void> createUser(NewUserRequest request) {
        User user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .countryCode(request.countryCode())
                .phone(request.phone())
                .accountLocked(false)
                .createdOn(LocalDate.now())
                .build();
        return usersRepository.saveUser(user).then();
    }

}
