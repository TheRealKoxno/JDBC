package miptjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class BoardingPass {
    private String ticketNumber;
    private Long flightId;
    private TicketFlight ticketFlight;
    private Long boardingNo;
    private String seatNo;

}
