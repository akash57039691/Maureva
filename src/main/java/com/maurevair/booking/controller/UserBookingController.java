package com.maurevair.booking.controller;

import com.maurevair.booking.dto.UserBookingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/user-booking/")
public class UserBookingController {

    @PostMapping(value = "upload/flight")
    public ResponseEntity<String> uploadFlight(@RequestBody UserBookingDto userBookingDto) {
        return ResponseEntity.ok("File saved.");
    }
}
