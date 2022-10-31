package com.femirion.clientservice.repository;

import com.femirion.clientservice.domain.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> getById();
}
