package com.maurevair.booking.service;

import com.maurevair.booking.model.Booking;

import java.util.Optional;

public interface BookingService {

    Optional<Booking> findById(Long id);
}
