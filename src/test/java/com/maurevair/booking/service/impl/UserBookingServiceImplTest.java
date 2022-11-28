package com.maurevair.booking.service.impl;

import com.maurevair.booking.dto.UserBookingDto;
import com.maurevair.booking.model.Booking;
import com.maurevair.booking.model.Flight;
import com.maurevair.booking.model.User;
import com.maurevair.booking.repository.UserBookingRepository;
import com.maurevair.booking.service.BookingService;
import com.maurevair.booking.service.FlightService;
import com.maurevair.booking.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserBookingServiceImplTest {

    @InjectMocks
    private UserBookingServiceImpl userBookingService;

    @Mock
    private FlightService flightService;

    @Mock
    private UserService userService;

    @Mock
    private BookingService bookingService;

    @Mock
    private UserBookingRepository userBookingRepository;

    private UserBookingDto userBookingDto;
    private Flight flight;
    private User user;
    private Booking booking;

    @Before
    public void init() {
        userBookingDto = new UserBookingDto();
        userBookingDto.setBookingId(1L);
        userBookingDto.setUserId(1L);
        userBookingDto.setFlightId(1L);

        flight = new Flight();
        flight.setId(1L);

        user = new User();
        user.setId(1L);

        booking = new Booking();
        booking.setId(1L);
    }

    @Test
    public void testBookFlight() {
        when(flightService.findById(any())).thenReturn(Optional.of(flight));
        when(userService.findById(any())).thenReturn(Optional.of(user));
        when(bookingService.findById(any())).thenReturn(Optional.of(booking));
        userBookingService.bookFlight(userBookingDto);
        verify(userBookingRepository, times(1)).save(any());
    }

    @Test(expected = ResponseStatusException.class)
    public void testBookFlightException() {
        userBookingService.bookFlight(userBookingDto);
    }
}
