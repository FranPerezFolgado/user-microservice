package com.fpf.homecollector.user_microservice.infrastructure.configuration.dto;

import java.time.LocalDateTime;

public record ErrorResponseDto(
        String reason,
        int status,
        String message,
        LocalDateTime timeStamp
) {
    public ErrorResponseDto(String reason, int status, String message) {
        this(reason, status, message, LocalDateTime.now());
    }
}
