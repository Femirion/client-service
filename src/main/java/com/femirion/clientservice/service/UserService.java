package com.femirion.clientservice.service;

import com.femirion.clientservice.domain.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User getUserById(UUID userId);

    List<User> getAll();

    User save(User user);

    User update(User user);

    void remove(UUID userId);
}
