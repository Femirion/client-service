package com.femirion.clientservice.service;

import com.femirion.clientservice.domain.User;
import com.femirion.clientservice.interact.AvatarProvider;
import com.femirion.clientservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AvatarProvider avatarProvider;

    @Override
    public User getUserById(UUID userId) {
        var user = userRepository.getById(userId);
        log.debug("Getting user by Id={}, user={}", userId, user);
        return user.orElse(null);
    }

    @Override
    public List<User> getAll() {
        var users = userRepository.getAll();
        log.debug("Getting users, size={}", users.size());
        return users;
    }

    @Override
    public User save(User user) {
        var savedUser = userRepository.save(user);
//        TODO execute another microservice
//        avatarProvider.getAvatarByUserId(savedUser.id());
        log.debug("Save user={}", savedUser);
        return savedUser;
    }

    @Override
    public User update(User user) {
        var updatedUser = userRepository.update(user);
        log.debug("Update user={}", updatedUser);
        return updatedUser;
    }

    @Override
    public void remove(UUID userId) {
        log.debug("Revome user by id, id={}", userId);
        userRepository.remove(userId);
    }
}
