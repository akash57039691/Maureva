package com.maurevair.booking.controller;

import com.maurevair.booking.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/airline/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "save-user")
    public ResponseEntity<String> saveUser() {
        userService.saveUser();
        return ResponseEntity.ok("User saved.");
    }
}
