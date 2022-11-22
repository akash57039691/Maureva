package com.maurevair.booking.service.impl;

import com.maurevair.booking.csv.AirportCSV;
import com.maurevair.booking.dto.AirportOnlyDto;
import com.maurevair.booking.dto.AvailableFlightsDto;
import com.maurevair.booking.mapper.AirportMapper;
import com.maurevair.booking.mapper.FlightMapper;
import com.maurevair.booking.model.Airport;
import com.maurevair.booking.repository.AirportRepository;
import com.maurevair.booking.service.AirportService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;
    private final FlightMapper flightMapper;

    public AirportServiceImpl(AirportRepository airportRepository,
            AirportMapper airportMapper, FlightMapper flightMapper) {
        this.airportRepository = airportRepository;
        this.airportMapper = airportMapper;
        this.flightMapper = flightMapper;
    }

    @Override
    public void uploadAirport(MultipartFile file) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(AirportCSV.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<AirportCSV> csv = csvToBean.parse();
            var toSaveAirports = new ArrayList<Airport>();
            csv.forEach(airportCSV -> {
                Airport airport = new Airport();
                airport.setAirportCode(airportCSV.getAirportCode());
                airport.setCity(airportCSV.getCity());
                airport.setRegion(airportCSV.getRegion());
                airport.setCountry(airportCSV.getCountry());
                toSaveAirports.add(airport);
            });
            airportRepository.saveAll(toSaveAirports);

        } catch (IOException ioException) {
            throw new IOException("File not saved!");
        }
    }

    @Override
    public List<AirportOnlyDto> findListOfAirport() {
        return airportMapper.convertToDto(airportRepository.findAll());
    }

    @Override
    public AirportOnlyDto findById(Long id) {
        return airportMapper.convertAirportToDto(airportRepository.findById(id).orElse(null));
    }

    @Override
    public List<AvailableFlightsDto> findAvailableFlight() {
        var availableFlights = airportRepository.findAvailableFlights();
        var flights = availableFlights.stream()
                .map(Airport::getFlightList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return flightMapper.convertAvailableFlights(flights);
    }
}
