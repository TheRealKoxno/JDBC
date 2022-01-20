CREATE TABLE air_travels.boarding_passes (
     `ticket_no` CHAR(13) NOT NULL,
     `flight_id` INT NOT NULL,
     `boarding_no` INT NOT NULL,
     `seat_no` VARCHAR(4) NOT NULL,
     PRIMARY KEY (`ticket_no`, `flight_id`),
     UNIQUE INDEX `ticket_no_UNIQUE` (`ticket_no` ASC, `flight_id` ASC) VISIBLE,
     CONSTRAINT `boarding_passes_flight_id`
         FOREIGN KEY (`flight_id`)
             REFERENCES `ticket_flights` (`flight_id`)
             ON DELETE cascade
             ON UPDATE cascade,
     CONSTRAINT `boarding_passes_ticket_flights`
         FOREIGN KEY (`ticket_no`)
             REFERENCES `ticket_flights` (`ticket_no`)
             ON DELETE cascade
             ON UPDATE cascade);
