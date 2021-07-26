package com.library.service;

import com.library.dto.enums.UserRole;
import com.library.dto.enums.UserStatus;
import com.library.exceptions.UserAlreadyExistException;
import com.library.model.UserRepository;
import com.library.model.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public void register(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistException(String.format("User with specified email already exist %s", user.getEmail()));
        }
        user.setUserRole(UserRole.ROLE_USER);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setUserStatus(UserStatus.ACTIVE);
        userRepository.save(user);
    }
}
