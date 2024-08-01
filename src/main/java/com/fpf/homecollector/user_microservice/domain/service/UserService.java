package com.fpf.homecollector.user_microservice.domain.service;

import com.fpf.homecollector.user_microservice.domain.User;

import java.util.UUID;

public interface UserService {

    UUID saveUser(final User user);

    User findUser(final UUID userId);


    void delete(UUID userId);
}
