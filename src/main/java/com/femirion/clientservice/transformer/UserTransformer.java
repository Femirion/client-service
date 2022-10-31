package com.femirion.clientservice.transformer;

import com.femirion.clientservice.api.dto.UserDto;
import com.femirion.clientservice.domain.User;
import org.springframework.stereotype.Component;

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

}
