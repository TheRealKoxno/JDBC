package miptjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
public class Airport {
    private String airportCode;
    private String airportName;
    private String city;
    private String coordinates;
    private String timezone;
}
