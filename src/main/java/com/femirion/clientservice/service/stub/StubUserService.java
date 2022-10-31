package com.femirion.clientservice.service.stub;

import com.femirion.clientservice.domain.User;
import com.femirion.clientservice.repository.UserRepository;
import com.femirion.clientservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class StubUserService implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getUserById(UUID userId) {
        var user = userRepository.getById(userId);
        log.debug("Getting user by Id={}, user={}", user);
        return user.orElse(null);
    }
}
