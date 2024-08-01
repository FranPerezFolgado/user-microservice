package com.fpf.homecollector.user_microservice.application.response;

import com.fpf.homecollector.user_microservice.domain.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapperUtils {


    public static FindUserResponse mapFindUser(User user) {
        return new FindUserResponse(
                user.getId(),
                user.getUsername(),
                user.getName(),
                user.getBirthDate(),
                user.getGender()
        );

    }

}
