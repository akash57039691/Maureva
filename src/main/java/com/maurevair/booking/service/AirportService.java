package com.maurevair.booking.service;

import com.maurevair.booking.dto.AirportOnlyDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AirportService {

    void uploadAirport(MultipartFile file) throws IOException;

    List<AirportOnlyDto> findListOfAirport();

    AirportOnlyDto findById(Long id);
}
