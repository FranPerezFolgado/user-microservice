package com.fpf.homecollector.user_microservice.domain.repository;

import com.fpf.homecollector.user_microservice.domain.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    void save(User user);

    Optional<User> findById(UUID id);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String any);

    void deleteById(UUID id);
}
