package com.fpf.homecollector.user_microservice.application;

import com.fpf.homecollector.user_microservice.application.request.CreateUserRequest;
import com.fpf.homecollector.user_microservice.application.response.CreateUserResponse;
import com.fpf.homecollector.user_microservice.application.response.FindUserResponse;
import com.fpf.homecollector.user_microservice.application.response.UserMapperUtils;
import com.fpf.homecollector.user_microservice.domain.service.UserService;
import com.fpf.homecollector.user_microservice.infrastructure.exception.UserAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users/v1")
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) throws UserAlreadyExistException {
        UUID id = userService.createUser(request.mapToEntity());
        log.debug("User created: {}", id);
        return new CreateUserResponse(id);
    }

    @GetMapping("/{userId}")
    public FindUserResponse findBook(@PathVariable("userId") UUID bookId) {
        return UserMapperUtils.mapFindUser(userService.findUser(bookId));
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable("userId") UUID userId) {
        userService.delete(userId);
    }

}
