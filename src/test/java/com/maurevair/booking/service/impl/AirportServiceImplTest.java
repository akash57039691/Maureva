package com.maurevair.booking.service.impl;

import com.maurevair.booking.repository.AirportRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AirportServiceImplTest {

    @InjectMocks
    private AirportServiceImpl airportService;

    @Mock
    private AirportRepository airportRepository;

    private MultipartFile file;

    @Before
    public void init() {
        file = new MockMultipartFile(
                "file",
                "test.csv"
                , MediaType.TEXT_PLAIN_VALUE,
                "Testing Data".getBytes());
    }

    @Test
    public void testUploadAirport() throws IOException {
        airportService.uploadAirport(file);
        verify(airportRepository, times(1)).saveAll(any());
    }
}
