package com.maurevair.booking.repository;

import com.maurevair.booking.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

    Airport findByAirportCode(String airportCode);

    @Query("SELECT a, f FROM Airport AS a INNER JOIN Flight AS f ON a.airportCode = f.origin")
    List<Airport> findAvailableFlights();
}
