package com.femirion.clientservice.service;

import com.femirion.clientservice.domain.User;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

public interface UserService {

    User getUserById(UUID userId);

    List<User> getAll();
}
