package com.femirion.clientservice.transformer;

import com.femirion.clientservice.api.dto.UserDto;
import com.femirion.clientservice.domain.User;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class UserTransformerTest {
    private UserTransformer sut = new UserTransformer();

    @Test
    public void userDtoMapToUser() {
        // given
        var userDto = new UserDto(UUID.randomUUID(), "email1", "firstName1", "lastName1", "avatar1");

        // when
        var result = sut.map(userDto);

        // then
        assertThat(result)
                .hasFieldOrPropertyWithValue("id", userDto.id())
                .hasFieldOrPropertyWithValue("email", userDto.email())
                .hasFieldOrPropertyWithValue("firstName", userDto.firstName())
                .hasFieldOrPropertyWithValue("lastName", userDto.lastName())
                .hasFieldOrPropertyWithValue("avatar", userDto.avatar());
    }

    @Test
    public void userMapToUserDto() {
        // given
        var user = new User(UUID.randomUUID(), "email1", "firstName1", "lastName1", "avatar1");

        // when
        var result = sut.map(user);

        // then
        assertThat(result)
                .hasFieldOrPropertyWithValue("id", user.id())
                .hasFieldOrPropertyWithValue("email", user.email())
                .hasFieldOrPropertyWithValue("firstName", user.firstName())
                .hasFieldOrPropertyWithValue("lastName", user.lastName())
                .hasFieldOrPropertyWithValue("avatar", user.avatar());
    }

}