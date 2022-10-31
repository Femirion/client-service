package com.femirion.clientservice.service;

import com.femirion.clientservice.domain.User;

import java.util.UUID;

public interface UserService {

    User getUserById(UUID userId);
}
