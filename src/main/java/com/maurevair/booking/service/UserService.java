package com.maurevair.booking.service;

import com.maurevair.booking.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long id);

    void saveUser();
}
