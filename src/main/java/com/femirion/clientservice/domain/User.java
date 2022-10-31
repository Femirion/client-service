package com.femirion.clientservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record User(
        UUID id,
        String email,
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName,
        String avatar) {
}
