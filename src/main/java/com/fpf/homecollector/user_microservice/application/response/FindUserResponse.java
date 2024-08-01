package com.fpf.homecollector.user_microservice.application.response;

import com.fpf.homecollector.user_microservice.domain.enums.GenderEnum;

import java.time.LocalDate;
import java.util.UUID;

public record FindUserResponse(
        UUID id,
        String username,
        String name,
        LocalDate birthDate,
        GenderEnum gender
) {


}
