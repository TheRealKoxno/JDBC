package miptjava;

import com.mysql.cj.jdbc.MysqlDataSource;
import miptjava.service.db.Uploader;
import miptjava.service.parser.Parser;

import java.sql.SQLException;

public class DataUploader {

    public void uploadAll() throws SQLException {
        var dataSource = new MysqlDataSource();
        dataSource.setUser("newuser");
        dataSource.setPassword("QAZPLMWSXokn1029");
        dataSource.setURL("jdbc:mysql://localhost:3306/");
        var uploader = new Uploader(dataSource);
        uploader.saveAirport(Parser.getAirport());
        uploader.saveBooking(Parser.getBooking());
        uploader.saveAircraft(Parser.getAircraft());
        uploader.saveSeat(Parser.getSeat());
        uploader.saveTicket(Parser.getTicket());
        uploader.saveFlight(Parser.getFlight());
        uploader.saveTicketFlight(Parser.getTicketFlight());
        uploader.saveBoardingPass(Parser.getBoardingPass());
    }
}
