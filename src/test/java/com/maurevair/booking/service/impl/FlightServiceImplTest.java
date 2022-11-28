package com.maurevair.booking.service.impl;

import com.maurevair.booking.model.Airport;
import com.maurevair.booking.repository.AirportRepository;
import com.maurevair.booking.repository.FlightRepository;
import org.h2.util.IOUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FlightServiceImplTest {

    @InjectMocks
    private FlightServiceImpl flightService;

    @Mock
    private AirportRepository airportRepository;

    @Mock
    private FlightRepository flightRepository;

    private Airport airport;

    @Before
    public void init() {
        airport = new Airport();
        airport.setId(1L);
    }


    @Test
    @Ignore
    public void testUploadFlights() throws JAXBException, IOException {

        MultipartFile multipartFile = new MockMultipartFile("flight.xml", new FileInputStream("/src/resources/flight"
                + ".xml"));

        when(airportRepository.findByAirportCode(any())).thenReturn(airport);
        flightService.uploadFlight(multipartFile);
        verify(flightRepository, times(1)).save(any());
    }
}
