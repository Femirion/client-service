package com.femirion.clientservice.api;

import com.femirion.clientservice.api.dto.UserDto;
import com.femirion.clientservice.service.UserService;
import com.femirion.clientservice.transformer.UserTransformer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController("/v1")
public class UserController {
    private final UserService userService;
    private final UserTransformer userTransformer;

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") UUID userId) {
        return ResponseEntity.ok(userTransformer.map(userService.getUserById(userId)));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userTransformer.map(userService.getAll()));
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userTransformer.map(userService.save(userTransformer.map(userDto))));
    }

    @PutMapping("/users")
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userTransformer.map(userService.update(userTransformer.map(userDto))));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> remove(@PathVariable("userId") UUID userId) {
        userService.remove(userId);
        return ResponseEntity.status(200).build();
    }

}
