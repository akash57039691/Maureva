package com.maurevair.booking.service.impl;

import com.maurevair.booking.model.Booking;
import com.maurevair.booking.model.Flight;
import com.maurevair.booking.repository.AirportRepository;
import com.maurevair.booking.repository.FlightRepository;
import com.maurevair.booking.service.FlightService;
import com.maurevair.booking.xml.BookingInfoXML;
import com.maurevair.booking.xml.FlightsXML;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;

    public FlightServiceImpl(FlightRepository flightRepository,
            AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    @Override
    public void uploadFlight(MultipartFile file) throws JAXBException, IOException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(FlightsXML.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FlightsXML flightsXML = (FlightsXML) unmarshaller.unmarshal(convertToFile(file));

            var flightList = flightsXML.getFlightList();
            var flightToSave = new ArrayList<Flight>();

            flightList.forEach(flightXML -> {
                Flight currentFlight = new Flight();
                currentFlight.setAirport(airportRepository.findByAirportCode(flightXML.getOrigin()));
                currentFlight.setFlightNumber(flightXML.getFlightNumber());
                currentFlight.setArrivalTime(flightXML.getArrivalTime());
                currentFlight.setCarrier(flightXML.getCarrier());
                currentFlight.setOrigin(flightXML.getOrigin());
                currentFlight.setDestination(flightXML.getDestination());
                currentFlight.setFlightId(flightXML.getId());
                currentFlight.setDepartureTime(flightXML.getDepartureTime());
                currentFlight.setBookingList(convertBooking(flightXML.getBookingInfoList(), currentFlight));
                flightToSave.add(currentFlight);
            });
            flightRepository.saveAll(flightToSave);

        } catch (UnmarshalException unmarshalException) {
            throw new UnmarshalException("Failed to convert XML.");
        }
    }

    @Override
    public Optional<Flight> findById(Long flightId) {
        return flightRepository.findById(flightId);
    }

    private File convertToFile(MultipartFile multipartFile) throws IOException {
        File convertFile = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        try (FileOutputStream fileOutputStream = new FileOutputStream(convertFile)) {
            fileOutputStream.write(multipartFile.getBytes());
        } catch (IOException ioException) {
            throw new IOException("Invalid file!");
        }
        return convertFile;
    }

    private List<Booking> convertBooking(List<BookingInfoXML> bookingInfoXMLS, Flight flight) {
        return bookingInfoXMLS.stream()
                .map(bookingInfoXML -> {
                    Booking booking = new Booking();
                    booking.setFlight(flight);
                    booking.setCabinClass(bookingInfoXML.getCabinClass());
                    booking.setSeatAvailable(bookingInfoXML.getSeatAvailable());
                    return booking;
                }).collect(Collectors.toList());
    }
}
