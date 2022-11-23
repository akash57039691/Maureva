package com.maurevair.booking.dto;

import lombok.Data;

@Data
public class BookingDto {
    private Long id;
    private String cabinClass;
    private Long seatAvailable;
}
