package com.fpf.homecollector.user_microservice.infrastructure.exception;


public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
