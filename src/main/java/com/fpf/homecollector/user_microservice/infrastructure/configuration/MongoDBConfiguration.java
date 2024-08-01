package com.fpf.homecollector.user_microservice.infrastructure.configuration;

import com.fpf.homecollector.user_microservice.infrastructure.repository.SpringMongoUserRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = SpringMongoUserRepository.class)
public class MongoDBConfiguration {
}
