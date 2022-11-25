package com.maurevair.booking.repository;

import com.maurevair.booking.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

    Airport findByAirportCode(String airportCode);
}
