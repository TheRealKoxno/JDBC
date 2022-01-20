package miptjava;

import com.mysql.cj.jdbc.MysqlDataSource;
import miptjava.domain.BoardingPass;
import miptjava.service.db.SimpleJdbcTemplate;
import miptjava.service.parser.Parser;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class TaskB {
    private final  SimpleJdbcTemplate source;
    public TaskB() {
        var dataSource = new MysqlDataSource();
        dataSource.setUser("newuser");
        dataSource.setPassword("QAZPLMWSXokn1029");
        dataSource.setURL("jdbc:mysql://localhost:3306/air_travels");
        source = new SimpleJdbcTemplate(dataSource);
    }

    public void missionOne() throws SQLException {
        source.preparedStatement("select JSON_EXTRACT(city, '$.en'), airport_code from airports where JSON_EXTRACT(city, '$.en') in (SELECT JSON_EXTRACT(city, '$.en') " +
                "FROM `air_travels`.`airports`" +
                " group by city having count(1) > 1)", citiesSelect -> {
            var dict = new HashMap<String, ArrayList<String>>();
            try (var set = citiesSelect.executeQuery()) {
                while (set.next()) {
                    var city = set.getString(1);
                    var code = set.getString(2);
                    if (!dict.containsKey(city))
                        dict.put(city, new ArrayList<>());
                    dict.get(city).add(code);
                }
                for (var city: dict.keySet()) {
                    System.out.println(String.format("%s\t: %s", city, String.join(", ", dict.get(city))));
                }
            }
                });
    }

    public void missionTwo() throws SQLException {
        source.preparedStatement("SELECT JSON_EXTRACT(a.city, '$.en'), count(1) as 'canceled' " +
                "FROM `air_travels`.`airports` a " +
                "join air_travels.flights f on f.departure_airport = a.airport_code " +
                "where f.status = 'Cancelled' " +
                "group by a.city " +
                "order by count(1) desc", citiesSelect -> {
            try (var set = citiesSelect.executeQuery()) {
                while (set.next()) {
                    System.out.println(String.format("%s\t: %d", set.getString(1), set.getInt(2)));
                }
                //;
//                    while (set.n)
            }
        });

    }

    public void missionThree() throws SQLException {
        source.preparedStatement("select JSON_EXTRACT(frm.city, '$.en'), JSON_EXTRACT(too.city, '$.en'), t.avggg / 100 as 'min' from (" +
                "SELECT f.departure_airport, f.arrival_airport, avg(f.actual_arrival - f.actual_departure) as avggg " +
                        "FROM air_travels.flights f " +
                        "where f.actual_arrival is not null " +
                        "and f.actual_departure is not null " +
                        "group by f.departure_airport, f.arrival_airport) as t " +
                        "join air_travels.airports frm on frm.airport_code = t.departure_airport " +
                        "join air_travels.airports too on too.airport_code = t.arrival_airport " +
                        "order by  t.avggg ", timeDuringSelect -> {
            try (var set = timeDuringSelect.executeQuery()) {
                while (set.next()) {
                    System.out.println(String.format("%s -> %s\t: %f", set.getString(1), set.getString(2), set.getDouble(3)));
                }
                //;
//                    while (set.n)
            }
        });

    }

    public void missionFour() throws SQLException {
        source.preparedStatement("select " +
                "MONTH(scheduled_departure), " +
                " count(1) " +
                "from air_travels.flights " +
                "where status = 'Cancelled' " +
                "group by MONTH(scheduled_departure) " +
                "order by count(1)", citiesSelect -> {
            try (var set = citiesSelect.executeQuery()) {
                while (set.next()) {
                    var mounth = set.getString(1);
                    String m;
                    switch (mounth) {
                        case "1":
                            m = "jan";
                            break;
                        case "2":
                            m = "feb";
                            break;
                        case "3":
                            m = "mar";
                            break;
                        case "4":
                            m = "apr";
                            break;
                        case "5":
                            m = "may";
                            break;
                        case "6":
                            m = "jun";
                            break;
                        case "7":
                            m = "jul";
                            break;
                        case "8":
                            m = "aug";
                            break;
                        case "9":
                            m = "sep";
                            break;
                        case "10":
                            m = "oct";
                            break;
                        case "11":
                            m = "nov";
                            break;
                        default:
                            m = "dec";
                    }
                    System.out.println(String.format("%s\t: %d", m, set.getInt(2)));
                }
                //;
//                    while (set.n)
            }
        });

    }
}
