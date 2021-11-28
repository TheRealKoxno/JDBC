CREATE TABLE air_travels.aircrafts (
       `aircraft_code` CHAR(3) NOT NULL,
       `model` JSON NOT NULL,
       `range` INT NOT NULL,
       PRIMARY KEY (`aircraft_code`),
       UNIQUE INDEX `aircraft_code_UNIQUE` (`aircraft_code` ASC) VISIBLE);
