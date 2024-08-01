package com.fpf.homecollector.user_microservice.domain;

import com.fpf.homecollector.user_microservice.domain.enums.GenderEnum;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class User {

    private UUID id;
    private String username;
    private String password;
    private String name;
    private LocalDate birthDate;
    private GenderEnum gender;

    public User() {

    }

    public User(String username, String password, String name, LocalDate birthDate, GenderEnum gender) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }
}
