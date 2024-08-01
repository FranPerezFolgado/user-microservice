package com.fpf.homecollector.user_microservice.infrastructure.service;

import com.fpf.homecollector.user_microservice.domain.User;
import com.fpf.homecollector.user_microservice.domain.repository.UserRepository;
import com.fpf.homecollector.user_microservice.domain.service.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UUID saveUser(User user) {
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
