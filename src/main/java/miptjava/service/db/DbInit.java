package miptjava.service.db;

import lombok.AllArgsConstructor;
import miptjava.App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.stream.Collectors;

/**
 * Initializes database
 */
@AllArgsConstructor
public class DbInit {
    final SimpleJdbcTemplate source;

    private String getSQL(String name) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        App.class.getResourceAsStream(name),
                        StandardCharsets.UTF_8))) {
            return br.lines().collect(Collectors.joining("\n"));
        }
    }

    public void create() throws SQLException, IOException {
        for (var name : new String[]{
                "createDb.sql",
                "createTableAirports.sql",
                "createTableAircrafts.sql",
                "createTableBookings.sql",
                "createTableFlights.sql",
                "createTableSeats.sql",
                "createTableTickets.sql",
                "createTableTicketFlights.sql",
                "createTableBoardingPasses.sql"
        }) {
            String sql = getSQL(name);
            source.statement(stmt -> {
                stmt.execute(sql);
            });
        }
    }
}