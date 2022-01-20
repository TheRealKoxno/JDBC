package miptjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor

public class Flight {
    private Long flightId;
    private String flightNo;
    private Timestamp scheduleDeparture;
    private Timestamp scheduledArrival;
    private Airport departureAirport;
    private String departureAirportCode;
    private Airport arrivalAirport;
    private String arrivalAirportCode;
    private String status;
    private Aircraft aircraft;
    private String aircraftCode;
    private Timestamp actualDeparture;
    private Timestamp actualArrival;
}
