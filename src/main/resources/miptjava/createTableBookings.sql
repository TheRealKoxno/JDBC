CREATE TABLE air_travels.bookings (
      `book_ref` CHAR(6) NOT NULL,
      `book_date` TIMESTAMP NOT NULL,
      `total_amount` DECIMAL(10,2) NOT NULL,
      PRIMARY KEY (`book_ref`),
      UNIQUE INDEX `book_ref_UNIQUE` (`book_ref` ASC) VISIBLE);
