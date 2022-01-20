package miptjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor

public class Ticket {
    private String ticketNo;
    private Booking Booking;
    private String bookRef;
    private String passengerId;
    private String passengerName;
    private String contactData;
}
