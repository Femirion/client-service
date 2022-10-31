package com.femirion.clientservice.repository;

import com.femirion.clientservice.domain.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    Optional<User> getById(UUID userId);

    List<User> getAll();

    User save(User user);

    User update(User user);

    void remove(UUID userId);
}
