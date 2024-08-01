package com.fpf.homecollector.user_microservice.infrastructure.repository;

import com.fpf.homecollector.user_microservice.domain.User;
import com.fpf.homecollector.user_microservice.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class MongoUserRespository implements UserRepository {

    private final SpringMongoUserRepository userRepository;


    @Override
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }


    @Override
    public void save(User user) {
        userRepository.save(user);
    }


}
