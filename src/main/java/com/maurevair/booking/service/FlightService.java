package com.maurevair.booking.service;

import com.maurevair.booking.dto.AvailableFlightsDto;
import com.maurevair.booking.model.Flight;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface FlightService {

    void uploadFlight(MultipartFile file) throws JAXBException, IOException;

    Optional<Flight> findById (Long flightId);

    List<AvailableFlightsDto> findAvailableFlight();
}
