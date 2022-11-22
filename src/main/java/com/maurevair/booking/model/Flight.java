package com.maurevair.booking.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FLIGHT_ID", nullable = false)
    private Long id;
    @Column(name = "ID", nullable = false)
    private String flightId;
    @Column(name = "CARRIER", nullable = false)
    private String carrier;
    @Column(name = "FLIGHT_NUMBER", nullable = false)
    private Long flightNumber;
    @Column(name = "ORIGIN", nullable = false)
    private String origin;
    @Column(name = "DESTINATION", nullable = false)
    private String destination;
    @Column(name = "DEPARTURE_TIME", nullable = false)
    private Date departureTime;
    @Column(name = "ARRIVAL_TIME", nullable = false)
    private Date arrivalTime;
    @ManyToOne
    @JoinColumn(name = "AIRPORT_ID", referencedColumnName = "AIRPORT_ID", nullable = false)
    private Airport airport;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flight", cascade = CascadeType.PERSIST)
    private List<Booking> bookingList;
}
