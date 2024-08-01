package com.fpf.homecollector.user_microservice.infrastructure.repository;

import com.fpf.homecollector.user_microservice.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringMongoUserRepository extends MongoRepository<User, UUID> {

}