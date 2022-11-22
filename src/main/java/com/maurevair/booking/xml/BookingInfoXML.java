package com.maurevair.booking.xml;

import javax.xml.bind.annotation.XmlAttribute;

public class BookingInfoXML {
    private String cabinClass;
    private Long seatAvailable;

    public String getCabinClass() {
        return cabinClass;
    }

    @XmlAttribute(name = "CabinClass")
    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    public Long getSeatAvailable() {
        return seatAvailable;
    }

    @XmlAttribute(name = "SeatsAvailable")
    public void setSeatAvailable(Long seatAvailable) {
        this.seatAvailable = seatAvailable;
    }
}
