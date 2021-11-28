CREATE TABLE air_travels.tickets (
     `ticket_no` CHAR(13) NOT NULL,
     `book_ref` CHAR(6) NOT NULL,
     `passenger_id` VARCHAR(20) NOT NULL,
     `passenger_name` TEXT NOT NULL,
     `contact_data` JSON NULL,
     PRIMARY KEY (`ticket_no`),
     UNIQUE INDEX `ticket_no_UNIQUE` (`ticket_no` ASC) VISIBLE,
     CONSTRAINT `tickets_bookings`
         FOREIGN KEY (`book_ref`)
             REFERENCES `bookings` (`book_ref`)
             ON DELETE NO ACTION
             ON UPDATE NO ACTION);;
