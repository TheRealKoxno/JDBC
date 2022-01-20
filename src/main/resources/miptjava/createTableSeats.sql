CREATE TABLE air_travels.seats (
   `aircraft_code` CHAR(3) NOT NULL,
   `seat_no` VARCHAR(4) NOT NULL,
   `fare_conditions` VARCHAR(10) NOT NULL,
   PRIMARY KEY (`aircraft_code`, `seat_no`),
   CONSTRAINT `seats_aircrafts`
      FOREIGN KEY (`aircraft_code`)
      REFERENCES `aircrafts` (`aircraft_code`)
      ON DELETE NO ACTION
   ON UPDATE NO ACTION);
