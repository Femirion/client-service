package com.femirion.clientservice.transformer;

import com.femirion.clientservice.api.dto.UserDto;
import com.femirion.clientservice.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserTransformer {

    public UserDto map(User user) {
        return new UserDto(
                user.id(),
                user.email(),
                user.firstName(),
                user.lastName(),
                user.avatar()
        );
    }

    public List<UserDto> map(List<User> users) {
        return users.stream()
                .map(u -> new UserDto(
                        u.id(),
                        u.email(),
                        u.firstName(),
                        u.lastName(),
                        u.avatar()))
                .collect(Collectors.toList());
    }

}
