package com.maurevair.booking.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class AirportCSV {
    @CsvBindByName
    private String country;
    @CsvBindByName
    private String region;
    @CsvBindByName
    private String city;
    @CsvBindByName
    private String airportCode;
}
