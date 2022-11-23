package com.maurevair.booking.repository;

import com.maurevair.booking.model.UserBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookingRepository extends JpaRepository<UserBooking, Long> {

}
