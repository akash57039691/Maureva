package com.maurevair.booking.dto;

import lombok.Data;

import java.util.List;

@Data
public class AirportDto {
    private String country;
    private String region;
    private String city;
    private String airportCode;
    private List<FlightDto> flightList;
}
