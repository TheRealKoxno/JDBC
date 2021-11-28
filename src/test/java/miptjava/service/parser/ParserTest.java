package miptjava.service.parser;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

class ParserTest {

    @Test
    public void getAircraft() throws FileNotFoundException {
        var i = Parser.getAircraft();
        System.out.println(((List) i).get(0));
    }

    @Test
    public void getAirport() throws FileNotFoundException {
        var i = Parser.getAirport();
        System.out.println(((List) i).get(0));
    }

    @Test
    public void getBoardingPass() throws FileNotFoundException {
        var i = Parser.getBoardingPass();
        System.out.println(((List) i).get(0));
    }

    @Test
    public void getBooking() throws FileNotFoundException {
        var i = Parser.getBooking();
        System.out.println(((List) i).get(0));
    }

    @Test
    public void getFlight() throws FileNotFoundException {
        var i = Parser.getFlight();
        System.out.println(((List) i).get(0));
    }

    @Test
    public void getSeat() throws FileNotFoundException {
        var i = Parser.getSeat();
        System.out.println(((List) i).get(0));
    }

    @Test
    public void getTicket() throws FileNotFoundException {
        var i = Parser.getTicket();
        System.out.println(((List) i).get(0));
    }

    @Test
    public void getTicketFlight() throws FileNotFoundException {
        var i = Parser.getTicketFlight();
        System.out.println(((List) i).get(0));
    }
}