package com.maurevair.booking.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "booking")
public class Booking {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BOOKING_ID", nullable = false)
    private Long id;
    @Column(name = "CABIN_CLASS", nullable = false)
    private String cabinClass;
    @Column(name = "SEAT_AVAILABLE", nullable = false)
    private Long seatAvailable;
    @ManyToOne
    @JoinColumn(name = "FIGHT_ID", referencedColumnName = "FLIGHT_ID", nullable = false)
    private Flight flight;
}
