package miptjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class Seat {
    private Aircraft Aircraft;
    private String aircraftCode;
    private String seatNo;
    private String fareConditions;

}
