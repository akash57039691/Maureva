package com.maurevair.booking.controller;

import com.maurevair.booking.dto.UserBookingDto;
import com.maurevair.booking.service.UserBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/user-booking/")
public class UserBookingController {

    private final UserBookingService userBookingService;

    public UserBookingController(UserBookingService userBookingService) {
        this.userBookingService = userBookingService;
    }

    @PostMapping(value = "save")
    public ResponseEntity<String> bookFlight(@RequestBody UserBookingDto userBookingDto) {
        userBookingService.bookFlight(userBookingDto);
        return ResponseEntity.ok("Booking save.");
    }
}
