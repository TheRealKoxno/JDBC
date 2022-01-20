package miptjava.service.db;

import com.mysql.cj.jdbc.MysqlDataSource;
import miptjava.domain.Aircraft;
import miptjava.service.parser.Parser;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

class UploaderTest {


    @Test
    void uploaderAircraft() throws SQLException, FileNotFoundException {
        var dataSource = new MysqlDataSource();
        dataSource.setUser("newuser");
        dataSource.setPassword("QAZPLMWSXokn1029");
        dataSource.setURL("jdbc:mysql://localhost:3306/");
        var uploader = new Uploader(dataSource);
        uploader.saveAircraft(Parser.getAircraft());
    }

    @Test
    void uploaderAirport() throws SQLException, FileNotFoundException {
        var dataSource = new MysqlDataSource();
        dataSource.setUser("newuser");
        dataSource.setPassword("QAZPLMWSXokn1029");
        dataSource.setURL("jdbc:mysql://localhost:3306/");
        var uploader = new Uploader(dataSource);
        uploader.saveAirport(Parser.getAirport());
    }

    @Test
    void uploaderBoardingPass() throws SQLException, FileNotFoundException {
        var dataSource = new MysqlDataSource();
        dataSource.setUser("newuser");
        dataSource.setPassword("QAZPLMWSXokn1029");
        dataSource.setURL("jdbc:mysql://localhost:3306/");
        var uploader = new Uploader(dataSource);
        uploader.saveBoardingPass(Parser.getBoardingPass());
    }

    @Test
    void uploaderBooking() throws SQLException, FileNotFoundException {
        var dataSource = new MysqlDataSource();
        dataSource.setUser("newuser");
        dataSource.setPassword("QAZPLMWSXokn1029");
        dataSource.setURL("jdbc:mysql://localhost:3306/");
        var uploader = new Uploader(dataSource);
        uploader.saveBooking(Parser.getBooking());
    }

    @Test
    void uploaderFlight() throws SQLException, FileNotFoundException {
        var dataSource = new MysqlDataSource();
        dataSource.setUser("newuser");
        dataSource.setPassword("QAZPLMWSXokn1029");
        dataSource.setURL("jdbc:mysql://localhost:3306/");
        var uploader = new Uploader(dataSource);
        uploader.saveFlight(Parser.getFlight());
    }

    @Test
    void uploaderSeat() throws SQLException, FileNotFoundException {
        var dataSource = new MysqlDataSource();
        dataSource.setUser("newuser");
        dataSource.setPassword("QAZPLMWSXokn1029");
        dataSource.setURL("jdbc:mysql://localhost:3306/");
        var uploader = new Uploader(dataSource);
        uploader.saveSeat(Parser.getSeat());
    }

    @Test
    void uploaderTicketFlight() throws SQLException, FileNotFoundException {
        var dataSource = new MysqlDataSource();
        dataSource.setUser("newuser");
        dataSource.setPassword("QAZPLMWSXokn1029");
        dataSource.setURL("jdbc:mysql://localhost:3306/");
        var uploader = new Uploader(dataSource);
        uploader.saveTicketFlight(Parser.getTicketFlight());
    }

    @Test
    void uploaderTicket() throws SQLException, FileNotFoundException {
        var dataSource = new MysqlDataSource();
        dataSource.setUser("newuser");
        dataSource.setPassword("QAZPLMWSXokn1029");
        dataSource.setURL("jdbc:mysql://localhost:3306/");
        var uploader = new Uploader(dataSource);
        uploader.saveTicket(Parser.getTicket());
    }
}