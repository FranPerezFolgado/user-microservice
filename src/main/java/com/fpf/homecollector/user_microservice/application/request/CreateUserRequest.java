package com.fpf.homecollector.user_microservice.application.request;

import com.fpf.homecollector.user_microservice.domain.User;
import com.fpf.homecollector.user_microservice.domain.enums.GenderEnum;

import java.time.LocalDate;

public record CreateUserRequest(
        String username,
        String password,
        String name,
        LocalDate birthDate,
        GenderEnum gender
) {


    public User mapToEntity() {
        return new User(
                this.username,
                this.password,
                this.name,
                this.birthDate,
                this.gender
        );
    }
}
