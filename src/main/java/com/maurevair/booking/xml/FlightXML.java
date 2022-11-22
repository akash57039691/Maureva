package com.maurevair.booking.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;
import java.util.List;

public class FlightXML {

    private String id;
    private String carrier;
    private Long flightNumber;
    private String origin;
    private String destination;
    private Date departureTime;
    private Date arrivalTime;
    private List<BookingInfoXML> bookingInfoXMLList;

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public String getCarrier() {
        return carrier;
    }

    @XmlAttribute(name = "Carrier")
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Long getFlightNumber() {
        return flightNumber;
    }

    @XmlAttribute(name = "FlightNumber")
    public void setFlightNumber(Long flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    @XmlAttribute(name = "Origin")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    @XmlAttribute(name = "Destination")
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    @XmlAttribute(name = "DepartureTime")
    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    @XmlAttribute(name = "ArrivalTime")
    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<BookingInfoXML> getBookingInfoList() {
        return bookingInfoXMLList;
    }

    @XmlElement(name = "BookingInfo")
    public void setBookingInfoList(List<BookingInfoXML> bookingInfoXMLList) {
        this.bookingInfoXMLList = bookingInfoXMLList;
    }
}