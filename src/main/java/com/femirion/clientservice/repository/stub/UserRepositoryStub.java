package com.femirion.clientservice.repository.stub;

import com.femirion.clientservice.domain.User;
import com.femirion.clientservice.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

public class UserRepositoryStub implements UserRepository {
    private static final UUID USER_ID = UUID.fromString("19526519-4775-4ee8-97d2-fa61376455b5");
    private static final String EMAIL_FORMAT = "email_%s";
    private static final String FIRST_NAME_FORMAT = "firstName_%s";
    private static final String LAST_NAME_FORMAT = "lastName_%s";
    private static final String AVATAR_FORMAT = "avatar_%s";

    @Override
    public Optional<User> getById(UUID userId) {
        if (USER_ID.equals(userId)) {
            return Optional.empty();
        }

        var user = new User(
                userId,
                String.format(EMAIL_FORMAT, userId),
                String.format(FIRST_NAME_FORMAT, userId),
                String.format(LAST_NAME_FORMAT, userId),
                String.format(AVATAR_FORMAT, userId)
        );

        return Optional.of(user);
    }
}
