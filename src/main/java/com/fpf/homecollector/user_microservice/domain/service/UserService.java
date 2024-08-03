package com.fpf.homecollector.user_microservice.domain.service;

import com.fpf.homecollector.user_microservice.domain.User;
import com.fpf.homecollector.user_microservice.infrastructure.exception.UserAlreadyExistException;

import java.util.UUID;

public interface UserService {

    UUID createUser(final User user) throws UserAlreadyExistException;

    User findUser(final UUID userId);


    void delete(UUID userId);
}
