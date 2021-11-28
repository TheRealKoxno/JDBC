package miptjava.service.parser;

import antlr.DocBookCodeGenerator;
import miptjava.domain.*;
import miptjava.App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParser;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParserSettings;

public class Parser {
    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX");

    private static Collection<String[]> readFile(String path) {
        var file = new File(App.class.getResource(String.format("data/%s", path)).getPath());
        var sett = new CsvParserSettings();
        sett.setLineSeparatorDetectionEnabled(true);
        var prsr = new CsvParser(sett);
        prsr.beginParsing(file);
        var result = new ArrayList<String[]>();
        while (true) {
            var line = prsr.parseNext();
            if (line == null)
                break;
            result.add(line);
        }
        return result;
    }

    public static Collection<Aircraft> getAircraft() {
        var result = new ArrayList<Aircraft>();
        var lines = readFile("aircrafts_data.csv");
        for (var line: lines) {
            result.add(new Aircraft(line[0], line[1], Integer.parseInt(line[2])));
        }
        return result;
    }

    public static Collection<Airport> getAirport() {
        var result = new ArrayList<Airport>();
        var lines = readFile("airports_data.csv");
        for (var line: lines) {
            result.add(new Airport(line[0], line[1], line[2], line[3], line[4]));
        }
        return result;
    }

    public static Collection<BoardingPass> getBoardingPass() {
        var result = new ArrayList<BoardingPass>();
        var lines = readFile("boarding_passes.csv");
        for (var line: lines) {
            result.add(new BoardingPass(line[0], Long.parseLong(line[1]), null, Long.parseLong(line[2]), line[3]));
        }
        return result;
    }

    public static Collection<Booking> getBooking() {
        var result = new ArrayList<Booking>();
        var lines = readFile("bookings.csv");
        for (var line: lines) {
            result.add(new Booking(line[0], Timestamp.valueOf(ZonedDateTime.parse(line[1], dateTimeFormatter).toLocalDateTime()), BigDecimal.valueOf(Double.parseDouble(line[2]))));
        }
        return result;
    }

    public static Collection<Flight> getFlight() {
        var result = new ArrayList<Flight>();
        var lines = readFile("flights.csv");
        for (var line: lines) {
            result.add(new Flight(Long.parseLong(line[0]),
                    line[1],
                    Timestamp.valueOf(ZonedDateTime.parse(line[2], dateTimeFormatter).toLocalDateTime()),
                    Timestamp.valueOf(ZonedDateTime.parse(line[3], dateTimeFormatter).toLocalDateTime()),
                    null, line[4], null, line[5], line[6], null, line[7],
                    line[8] == null ? null : Timestamp.valueOf(ZonedDateTime.parse(line[8], dateTimeFormatter).toLocalDateTime()),
                    line[9] == null ? null : Timestamp.valueOf(ZonedDateTime.parse(line[9], dateTimeFormatter).toLocalDateTime())));
        }
        return result;
    }

    public static Collection<Seat> getSeat() {
        var result = new ArrayList<Seat>();
        var lines = readFile("seats.csv");
        for (var line: lines) {
            result.add(new Seat(null, line[0], line[1], line[2]));
        }
        return result;
    }

    public static Collection<Ticket> getTicket() {
        var result = new ArrayList<Ticket>();
        var lines = readFile("tickets.csv");
        for (var line: lines) {
            result.add(new Ticket(line[0], null, line[1], line[2], line[3], line[4]));
        }
        return result;
    }

    public static Collection<TicketFlight> getTicketFlight() {
        var result = new ArrayList<TicketFlight>();
        var lines = readFile("ticket_flights.csv");
        for (var line: lines) {
            result.add(new TicketFlight(line[0], null, null, Long.parseLong(line[1]), line[2], BigDecimal.valueOf(Double.parseDouble(line[3]))));
        }
        return result;
    }
}
