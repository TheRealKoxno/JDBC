package miptjava.service.db;

import miptjava.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

public class Uploader {
    private final DataSource connectionPool;
    private final SimpleJdbcTemplate source;
    public Uploader(DataSource ds) {
        connectionPool = ds;
        source = new SimpleJdbcTemplate(ds);
    }

    public void saveAircraft(Collection<Aircraft> aircrafts) throws SQLException {
        source.preparedStatement("insert into `air_travels`.`aircrafts` (`aircraft_code`, `model`, `range`) values (?, ?, ?)", insertAircraft -> {
            for (Aircraft aircraft : aircrafts) {
                insertAircraft.setString(1, aircraft.getAircraftCode());
                insertAircraft.setString(2, aircraft.getModel());
                insertAircraft.setInt(3, aircraft.getRange());
                insertAircraft.execute();
            }
        });
    }

    public void saveAirport(Collection<Airport> airports) throws SQLException {
        source.preparedStatement("insert into `air_travels`.`airports` (`airport_code`, `airport_name`, `city`, `coordinates`, `timezone`) values (?, ?, ?, point(?,?), ?)", insertAirport -> {
            for (Airport airport : airports) {
                insertAirport.setString(1, airport.getAirportCode());
                insertAirport.setString(2, airport.getAirportName());
                insertAirport.setString(3, airport.getCity());
                var andr = Arrays.stream(airport.getCoordinates().split("[)(]")[1].split(",")).mapToDouble(Double::parseDouble).toArray();
                insertAirport.setDouble(4, andr[0]);
                insertAirport.setDouble(5, andr[1]);
                insertAirport.setString(6, airport.getTimezone());
                insertAirport.execute();
            }
        });
    }

    public void saveBoardingPass(Collection<BoardingPass> boardingPasses) throws SQLException {
        source.preparedStatement("insert into `air_travels`.`boarding_passes` (`ticket_no`, `flight_id`, `boarding_no`, `seat_no`) values (?, ?, ?, ?)", insertBoardingPass -> {
            for (BoardingPass boardingPass : boardingPasses) {
                insertBoardingPass.setString(1, boardingPass.getTicketNumber());
                insertBoardingPass.setLong(2, boardingPass.getFlightId());
                insertBoardingPass.setLong(3, boardingPass.getBoardingNo());
                insertBoardingPass.setString(4, boardingPass.getSeatNo());
                insertBoardingPass.execute();
            }
        });
    }

    public void saveBooking(Collection<Booking> bookings) throws SQLException {
        source.preparedStatement("insert into `air_travels`.`bookings` (`book_ref`, `book_date`, `total_amount`) values (?, ?, ?)", insertBooking -> {
            for (Booking booking : bookings) {
                insertBooking.setString(1, booking.getBookRef());
                insertBooking.setTimestamp(2, booking.getBookDate());
                insertBooking.setBigDecimal(3, booking.getTotalAmount());
                insertBooking.execute();
            }
        });
    }

    public void saveFlight(Collection<Flight> flights) throws SQLException {
        source.preparedStatement("insert into `air_travels`.`flights` (`flight_id`, `flight_no`, `scheduled_departure`, `scheduled_arrival`, `departure_airport`, `arrival_airport`, `status`, `aircraft_code`, `actual_departure`, `actual_arrival`) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", insertFlight -> {
            for (Flight flight : flights) {
                insertFlight.setLong(1, flight.getFlightId());
                insertFlight.setString(2, flight.getFlightNo());
                insertFlight.setTimestamp(3, flight.getScheduleDeparture());
                insertFlight.setTimestamp(4, flight.getScheduledArrival());
                insertFlight.setString(5, flight.getDepartureAirportCode());
                insertFlight.setString(6, flight.getArrivalAirportCode());
                insertFlight.setString(7, flight.getStatus());
                insertFlight.setString(8, flight.getAircraftCode());
                insertFlight.setTimestamp(9, flight.getActualDeparture());
                insertFlight.setTimestamp(10, flight.getActualArrival());
                insertFlight.execute();
            }
        });
    }

    public void saveSeat(Collection<Seat> seats) throws SQLException {
        source.preparedStatement("insert into `air_travels`.`seats` (`aircraft_code`, `seat_no`, `fare_conditions`) values (?, ?, ?)", insertSeat -> {
            for (Seat seat : seats) {
                insertSeat.setString(1, seat.getAircraftCode());
                insertSeat.setString(2, seat.getSeatNo());
                insertSeat.setString(3, seat.getFareConditions());
                insertSeat.execute();
            }
        });
    }

    public void saveTicketFlight(Collection<TicketFlight> ticketFlights) throws SQLException {
        source.preparedStatement("insert into `air_travels`.`ticket_flights` (`ticket_no`, `flight_id`, `fare_conditions`, `amount`) values (?, ?, ?, ?)", insertTicketFlight -> {
            for (TicketFlight ticketFlight : ticketFlights) {
                insertTicketFlight.setString(1, ticketFlight.getTicketNo());
                insertTicketFlight.setLong(2, ticketFlight.getFlightId());
                insertTicketFlight.setString(3, ticketFlight.getFareConditions());
                insertTicketFlight.setBigDecimal(4, ticketFlight.getAmount());
                insertTicketFlight.execute();
            }
        });
    }

    public void saveTicket(Collection<Ticket> tickets) throws SQLException {
        source.preparedStatement("insert into `air_travels`.`tickets` (`ticket_no`, `book_ref`, `passenger_id`, `passenger_name`, `contact_data`) values (?, ?, ?, ?, ?)", insertTicket -> {
            for (Ticket ticket : tickets) {
                insertTicket.setString(1, ticket.getTicketNo());
                insertTicket.setString(2, ticket.getBookRef());
                insertTicket.setString(3, ticket.getPassengerId());
                insertTicket.setString(4, ticket.getPassengerName());
                insertTicket.setString(5, ticket.getContactData());
                insertTicket.execute();
            }
        });
    }
}
