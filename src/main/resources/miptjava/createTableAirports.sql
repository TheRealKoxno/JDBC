CREATE TABLE air_travels.airports (
        `airport_code` CHAR(3) NOT NULL,
        `airport_name` JSON NOT NULL,
        `city` JSON NOT NULL,
        `coordinates` POINT NOT NULL,
        `timezone` TEXT NOT NULL,
        PRIMARY KEY (`airport_code`),
        UNIQUE INDEX `aircraft_code_UNIQUE` (`airport_code` ASC) VISIBLE);
