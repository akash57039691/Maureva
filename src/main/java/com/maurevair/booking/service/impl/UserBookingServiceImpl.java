package com.maurevair.booking.service.impl;

import com.maurevair.booking.dto.UserBookingDto;
import com.maurevair.booking.model.UserBooking;
import com.maurevair.booking.repository.UserBookingRepository;
import com.maurevair.booking.service.BookingService;
import com.maurevair.booking.service.FlightService;
import com.maurevair.booking.service.UserBookingService;
import com.maurevair.booking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserBookingServiceImpl implements UserBookingService {

    private final UserBookingRepository userBookingRepository;
    private final FlightService flightService;
    private final UserService userService;
    private final BookingService bookingService;

    public UserBookingServiceImpl(UserBookingRepository userBookingRepository,
            FlightService flightService, UserService userService,
            BookingService bookingService) {
        this.userBookingRepository = userBookingRepository;
        this.flightService = flightService;
        this.userService = userService;
        this.bookingService = bookingService;
    }

    @Override
    public void bookFlight(UserBookingDto userBookingDto) {
        var flight = flightService.findById(userBookingDto.getFlightId());
        var user = userService.findById(userBookingDto.getUserId());
        var booking = bookingService.findById(userBookingDto.getBookingId());

        if (flight.isPresent() && user.isPresent() && booking.isPresent()) {
            UserBooking userBooking = new UserBooking();
            userBooking.setBookingId(userBookingDto.getBookingId());
            userBooking.setUserId(userBookingDto.getUserId());
            userBooking.setFlightId(userBookingDto.getFlightId());
            userBookingRepository.save(userBooking);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
