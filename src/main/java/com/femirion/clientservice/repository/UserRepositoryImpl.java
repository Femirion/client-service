package com.femirion.clientservice.repository;

import com.femirion.clientservice.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Profile("!stub")
@Service
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final Map<UUID, User> users = new ConcurrentHashMap<>();

    @Override
    public Optional<User> getById(UUID userId) {
        return Optional.ofNullable(users.get(userId));
    }

    @Override
    public List<User> getAll() {
        return users.values().stream()
                .toList();
    }

    @Override
    public User save(User user) {
        if (user.id() != null) {
            return update(user);
        }
        var userId = UUID.randomUUID();
        var newUser = new User(userId, user.email(), user.firstName(), user.lastName(), user.avatar());
        users.put(userId, newUser);
        return newUser;
    }

    @Override
    public User update(User user) {
        users.put(user.id(), user);
        return user;
    }

    @Override
    public void remove(UUID userId) {
        users.remove(userId);
    }
}
