package com.maurevair.booking.mapper;

import com.maurevair.booking.dto.AvailableFlightsDto;
import com.maurevair.booking.model.Flight;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper {

    List<AvailableFlightsDto> convertAvailableFlights(List<Flight> flights);
}
