package com.maurevair.booking.mapper;

import com.maurevair.booking.dto.AirportOnlyDto;
import com.maurevair.booking.model.Airport;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AirportMapper {

    List<AirportOnlyDto> convertToDto(List<Airport> airports);

    AirportOnlyDto convertAirportToDto(Airport airport);
}
