package com.femirion.clientservice.repository;

import com.femirion.clientservice.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Profile("!Stub")
@Service
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    @Override
    public Optional<User> getById(UUID userId) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return Collections.emptyList();
    }
}
