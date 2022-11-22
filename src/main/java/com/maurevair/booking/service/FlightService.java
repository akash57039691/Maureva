package com.maurevair.booking.service;

import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface FlightService {

    void uploadFlight(MultipartFile file) throws JAXBException, IOException;
}
