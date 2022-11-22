package com.maurevair.booking.dto;

import lombok.Data;

@Data
public class AirportOnlyDto {
    private String id;
    private String country;
    private String region;
    private String city;
    private String airportCode;
}
