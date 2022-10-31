package com.femirion.clientservice.api;

import com.femirion.clientservice.api.dto.UserDto;
import com.femirion.clientservice.service.UserService;
import com.femirion.clientservice.transformer.UserTransformer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController("/v1")
public class UserController {
    private final UserService userService;
    private final UserTransformer userTransformer;

    @GetMapping("/users/{userId}")
    public UserDto getUserById(@PathVariable("userId") UUID userId) {
        return userTransformer.map(userService.getUserById(userId));
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userTransformer.map(userService.getAll());
    }
}
