package com.fpf.homecollector.user_microservice.infrastructure.service;

import com.fpf.homecollector.user_microservice.domain.User;
import com.fpf.homecollector.user_microservice.domain.repository.UserRepository;
import com.fpf.homecollector.user_microservice.utils.UserUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    private UserRepository userRepository;
    private UserServiceImpl userService;

    @BeforeEach
    void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void saveUser() {
        User user = UserUtils.createUser();
        userService.saveUser(user);
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    void findUser() {
        User user = UserUtils.createUser();
        mockFindUser(user);
        User userFound = userService.findUser(user.getId());
        assertNotNull(userFound);
    }

    @Test
    void delete() {

        User book = UserUtils.createUser();
        mockFindUser(book);
        userService.delete(book.getId());

        verify(userRepository, times(1)).deleteById(any());

    }

    private void mockFindUser(User user) {
        doReturn(Optional.of(user)).when(userRepository).findById(any());
    }
}