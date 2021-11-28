CREATE TABLE air_travels.ticket_flights (
    `ticket_no` CHAR(13) NOT NULL,
    `flight_id` INT NOT NULL,
    `fare_conditions` VARCHAR(10) NOT NULL,
    `amount` DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (`ticket_no`, `flight_id`),
    UNIQUE INDEX `ticket_no_UNIQUE` (`ticket_no` ASC, `flight_id` ASC) VISIBLE,
    INDEX `flight_id_INDEX` (`flight_id` ASC) VISIBLE,
    CONSTRAINT `ticket_flights_tickets`
        FOREIGN KEY (`ticket_no`)
             REFERENCES `tickets` (`ticket_no`)
             ON DELETE cascade
             ON UPDATE cascade);
