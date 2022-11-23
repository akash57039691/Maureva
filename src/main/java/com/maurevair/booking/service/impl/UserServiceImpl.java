package com.maurevair.booking.service.impl;

import com.maurevair.booking.model.User;
import com.maurevair.booking.repository.UserRepository;
import com.maurevair.booking.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
