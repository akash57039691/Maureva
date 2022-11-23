package com.maurevair.booking.service.impl;

import com.maurevair.booking.model.Booking;
import com.maurevair.booking.repository.BookingRepository;
import com.maurevair.booking.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return bookingRepository.findById(id);
    }
}
