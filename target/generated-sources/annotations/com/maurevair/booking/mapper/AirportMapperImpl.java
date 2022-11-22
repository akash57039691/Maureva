package com.maurevair.booking.mapper;

import com.maurevair.booking.dto.AirportOnlyDto;
import com.maurevair.booking.model.Airport;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-23T00:16:15+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class AirportMapperImpl implements AirportMapper {

    @Override
    public List<AirportOnlyDto> convertToDto(List<Airport> airports) {
        if ( airports == null ) {
            return null;
        }

        List<AirportOnlyDto> list = new ArrayList<AirportOnlyDto>( airports.size() );
        for ( Airport airport : airports ) {
            list.add( convertAirportToDto( airport ) );
        }

        return list;
    }

    @Override
    public AirportOnlyDto convertAirportToDto(Airport airport) {
        if ( airport == null ) {
            return null;
        }

        AirportOnlyDto airportOnlyDto = new AirportOnlyDto();

        if ( airport.getId() != null ) {
            airportOnlyDto.setId( String.valueOf( airport.getId() ) );
        }
        airportOnlyDto.setCountry( airport.getCountry() );
        airportOnlyDto.setRegion( airport.getRegion() );
        airportOnlyDto.setCity( airport.getCity() );
        airportOnlyDto.setAirportCode( airport.getAirportCode() );

        return airportOnlyDto;
    }
}
