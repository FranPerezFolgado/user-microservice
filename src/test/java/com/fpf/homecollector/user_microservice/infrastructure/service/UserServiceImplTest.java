package com.fpf.homecollector.user_microservice.infrastructure.service;

import com.fpf.homecollector.user_microservice.domain.User;
import com.fpf.homecollector.user_microservice.domain.repository.UserRepository;
import com.fpf.homecollector.user_microservice.infrastructure.exception.UserAlreadyExistException;
import com.fpf.homecollector.user_microservice.utils.UserUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    private UserRepository userRepository;
    private UserServiceImpl userService;
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        passwordEncoder = Mockito.mock(PasswordEncoder.class);
        userService = new UserServiceImpl(userRepository, passwordEncoder);
    }

    @Test
    void createUser() throws UserAlreadyExistException {

        User user = UserUtils.createUser();
        userService.createUser(user);
        verify(userRepository, times(1)).findByEmail(any(String.class));
        verify(userRepository, times(1)).findByUsername(any(String.class));
        verify(passwordEncoder, times(1)).encode(any(String.class));
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void createUserMailAlreadyExist() {

        User user = UserUtils.createUser();
        doReturn(Optional.of(User.class)).when(userRepository).findByEmail(any(String.class));
        assertThrows(UserAlreadyExistException.class, () -> userService.createUser(user));

        verify(userRepository, times(1)).findByEmail(any(String.class));
    }

    @Test
    void createUserUsernameAlreadyExist() {

        User user = UserUtils.createUser();
        doReturn(Optional.of(User.class)).when(userRepository).findByUsername(any(String.class));
        assertThrows(UserAlreadyExistException.class, () -> userService.createUser(user));

        verify(userRepository, times(1)).findByEmail(any(String.class));
        verify(userRepository, times(1)).findByUsername(any(String.class));

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