package com.fpf.homecollector.user_microservice.infrastructure.service;

import com.fpf.homecollector.user_microservice.domain.User;
import com.fpf.homecollector.user_microservice.domain.repository.UserRepository;
import com.fpf.homecollector.user_microservice.domain.service.UserService;
import com.fpf.homecollector.user_microservice.infrastructure.exception.UserAlreadyExistException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UUID createUser(User user) throws UserAlreadyExistException {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistException("Email already registered");
        }
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistException("Username already registered");
        }

        user.updatePassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public User findUser(UUID userId) {
        return userRepository
                .findById(userId)
                .orElseThrow(() -> new RuntimeException("User with given id does not exist " + userId));
    }


    @Override
    public void delete(UUID userId) {
        userRepository.deleteById(userId);
    }


}
