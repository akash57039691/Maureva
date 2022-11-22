package com.maurevair.booking.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AIRPORT_ID", nullable = false)
    private Long id;
    @Column(name = "COUNTRY", nullable = false)
    private String country;
    @Column(name = "REGION")
    private String region;
    @Column(name = "CITY", nullable = false)
    private String city;
    @Column(name = "AIRPORT_CODE", nullable = false)
    private String airportCode;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "airport")
    private List<Flight> flightList;
}
