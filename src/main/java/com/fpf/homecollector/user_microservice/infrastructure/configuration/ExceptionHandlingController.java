package com.fpf.homecollector.user_microservice.infrastructure.configuration;

import com.fpf.homecollector.user_microservice.infrastructure.configuration.dto.ErrorResponseDto;
import com.fpf.homecollector.user_microservice.infrastructure.exception.UserAlreadyExistException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleUncaughtException(final Exception e, final HttpServletRequest request) {
        log.error("Generic error ", e);
        final ErrorResponseDto errorResponseDto = new ErrorResponseDto(e.getClass().getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDto);
    }

    @ExceptionHandler({UserAlreadyExistException.class})
    public ResponseEntity<Object> userExist(final UserAlreadyExistException e, final HttpServletRequest request) {
        log.error("User already exist", e);
        final ErrorResponseDto errorResponseDto = new ErrorResponseDto(UserAlreadyExistException.class.getSimpleName(), HttpStatus.PRECONDITION_FAILED.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(errorResponseDto);
    }


}
