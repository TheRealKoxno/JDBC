CREATE TABLE air_travels.flights (
    `flight_id` BIGINT NOT NULL,
    `flight_no` CHAR(6) NOT NULL,
    `scheduled_departure` TIMESTAMP NOT NULL,
    `scheduled_arrival` TIMESTAMP NOT NULL,
    `departure_airport` CHAR(3) NOT NULL,
    `arrival_airport` CHAR(3) NOT NULL,
    `status` VARCHAR(20) NOT NULL,
    `aircraft_code` CHAR(3) NOT NULL,
    `actual_departure` TIMESTAMP NULL,
    `actual_arrival` TIMESTAMP NULL,
    PRIMARY KEY (`flight_id`),
    UNIQUE INDEX `flight_id_UNIQUE` (`flight_id` ASC) VISIBLE,
    CONSTRAINT `flights_airports_from`
    FOREIGN KEY (`departure_airport`)
     REFERENCES `airports` (`airport_code`)
     ON DELETE NO ACTION
     ON UPDATE NO ACTION,
    CONSTRAINT `flights_airports_to`
    FOREIGN KEY (`arrival_airport`)
     REFERENCES `airports` (`airport_code`)
     ON DELETE NO ACTION
     ON UPDATE NO ACTION,
    CONSTRAINT `flights_aircrafts`
    FOREIGN KEY (`aircraft_code`)
     REFERENCES `aircrafts` (aircraft_code)
     ON DELETE NO ACTION
     ON UPDATE NO ACTION);