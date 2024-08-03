package com.fpf.homecollector.user_microservice.utils;

import com.fpf.homecollector.user_microservice.domain.User;
import com.fpf.homecollector.user_microservice.domain.enums.GenderEnum;

import java.time.LocalDate;

public class UserUtils {

    public static User createUser() {
        return new User("test", "pass", "test", LocalDate.now(), GenderEnum.MASCULINE);

    }

}
