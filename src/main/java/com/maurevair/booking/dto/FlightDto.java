package com.maurevair.booking.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FlightDto {
    private String flightId;
    private String carrier;
    private Long flightNumber;
    private String origin;
    private String destination;
    private Date departureTime;
    private Date arrivalTime;
    private List<BookingDto> bookingList;
}
