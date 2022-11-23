package com.maurevair.booking.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_booking")
@Setter
@Getter
public class UserBooking {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "USER_BOOKING_ID", nullable = false)
    private Long id;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "BOOKING_ID", nullable = false)
    private Long bookingId;

    @Column(name = "FLIGHT_ID", nullable = false)
    private Long flightId;
}
