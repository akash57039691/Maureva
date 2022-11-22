package com.maurevair.booking.controller;

import com.maurevair.booking.dto.AirportOnlyDto;
import com.maurevair.booking.dto.AvailableFlightsDto;
import com.maurevair.booking.service.AirportService;
import com.maurevair.booking.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/api/airline/")
public class AirlineController {

    private final FlightService flightService;
    private final AirportService airportService;

    public AirlineController(FlightService flightService, AirportService airportService) {
        this.flightService = flightService;
        this.airportService = airportService;
    }

    @PostMapping(value = "upload/flight")
    public ResponseEntity<String> uploadFlight(@RequestParam("file") MultipartFile file)
            throws JAXBException, IOException {
        flightService.uploadFlight(file);
        return ResponseEntity.ok("File saved.");
    }

    @PostMapping(value = "upload/airport")
    public ResponseEntity<String> uploadAirport(@RequestParam("file") MultipartFile file) throws IOException {
        airportService.uploadAirport(file);
        return ResponseEntity.ok("File saved.");
    }

    @GetMapping(value = "list/airport")
    public ResponseEntity<List<AirportOnlyDto>> listAirportAllDetails() {
        return ResponseEntity.ok(airportService.findListOfAirport());
    }

    @GetMapping(value = "list/airport/{id}")
    public ResponseEntity<AirportOnlyDto> getAirportById(@PathVariable Long id) {
        return ResponseEntity.ok(airportService.findById(id));
    }

    @GetMapping(value = "list/flight/available")
    public ResponseEntity<List<AvailableFlightsDto>> getAvailableFlights() {
        return ResponseEntity.ok(airportService.findAvailableFlight());
    }
}
