package com.maurevair.booking.dto;

import lombok.Data;

@Data
public class UserBookingDto {
    private Long userId;
    private Long flightId;
    private Long bookingId;
}
