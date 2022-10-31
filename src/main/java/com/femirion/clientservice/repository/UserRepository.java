package com.femirion.clientservice.repository;

import com.femirion.clientservice.domain.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public interface UserRepository {

    Optional<User> getById(UUID userId);
}
