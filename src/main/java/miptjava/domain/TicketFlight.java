package miptjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class TicketFlight {
    private String ticketNo;
    private Ticket ticket;
    private Flight flight;
    private Long flightId;
    private String fareConditions;
    private BigDecimal amount;
}
