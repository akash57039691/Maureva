package com.maurevair.booking.repository;

import com.maurevair.booking.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f, a FROM Flight AS f INNER JOIN Airport AS a ON f.origin = a.airportCode")
    List<Flight> findAvailableFlights();
}
