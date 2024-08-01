package com.fpf.homecollector.user_microservice.domain.service;

import com.fpf.homecollector.user_microservice.domain.repository.UserRepository;
import com.fpf.homecollector.user_microservice.infrastructure.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;


class UserServiceImplTest {

    private UserRepository userRepository;
    private UserServiceImpl userService;

    @BeforeEach
    void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
    }


}