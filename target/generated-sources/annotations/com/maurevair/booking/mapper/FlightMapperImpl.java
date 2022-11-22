package com.maurevair.booking.mapper;

import com.maurevair.booking.dto.AvailableFlightsDto;
import com.maurevair.booking.dto.BookingDto;
import com.maurevair.booking.model.Booking;
import com.maurevair.booking.model.Flight;
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
public class FlightMapperImpl implements FlightMapper {

    @Override
    public List<AvailableFlightsDto> convertAvailableFlights(List<Flight> flights) {
        if ( flights == null ) {
            return null;
        }

        List<AvailableFlightsDto> list = new ArrayList<AvailableFlightsDto>( flights.size() );
        for ( Flight flight : flights ) {
            list.add( flightToAvailableFlightsDto( flight ) );
        }

        return list;
    }

    protected BookingDto bookingToBookingDto(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        BookingDto bookingDto = new BookingDto();

        bookingDto.setCabinClass( booking.getCabinClass() );
        bookingDto.setSeatAvailable( booking.getSeatAvailable() );

        return bookingDto;
    }

    protected List<BookingDto> bookingListToBookingDtoList(List<Booking> list) {
        if ( list == null ) {
            return null;
        }

        List<BookingDto> list1 = new ArrayList<BookingDto>( list.size() );
        for ( Booking booking : list ) {
            list1.add( bookingToBookingDto( booking ) );
        }

        return list1;
    }

    protected AvailableFlightsDto flightToAvailableFlightsDto(Flight flight) {
        if ( flight == null ) {
            return null;
        }

        AvailableFlightsDto availableFlightsDto = new AvailableFlightsDto();

        availableFlightsDto.setFlightId( flight.getFlightId() );
        availableFlightsDto.setCarrier( flight.getCarrier() );
        availableFlightsDto.setFlightNumber( flight.getFlightNumber() );
        availableFlightsDto.setOrigin( flight.getOrigin() );
        availableFlightsDto.setDestination( flight.getDestination() );
        availableFlightsDto.setDepartureTime( flight.getDepartureTime() );
        availableFlightsDto.setArrivalTime( flight.getArrivalTime() );
        availableFlightsDto.setBookingList( bookingListToBookingDtoList( flight.getBookingList() ) );

        return availableFlightsDto;
    }
}
