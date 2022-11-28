package com.maurevair.booking.controller;

import com.maurevair.booking.model.Airport;
import com.maurevair.booking.service.FlightService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class AirlineControllerTest {

    @InjectMocks
    private AirlineController airlineController;

    @Mock
    private FlightService flightService;

    private MultipartFile file;

    @Before
    public void init() {
        file = new MockMultipartFile(
                "file",
                "flight.xml"
                , "multipart/form-data",
                "flight".getBytes());
    }

    @Test
    public void testAirlineController() throws JAXBException, IOException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        var result = airlineController.uploadFlight(file);

        assertThat(result.getStatusCodeValue()).isEqualTo(200);
        assertThat(result.getBody()).isEqualTo("File saved.");
    }

}
