package com.maurevair.booking.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "flights")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class FlightsXML {
    private List<FlightXML> flightXMLList;

    public List<FlightXML> getFlightList() {
        return flightXMLList;
    }

    @XmlElement(name = "flight")
    public void setFlightList(List<FlightXML> flightXMLList) {
        this.flightXMLList = flightXMLList;
    }
}
