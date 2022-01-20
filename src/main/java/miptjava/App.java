package miptjava;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.h2.jdbcx.JdbcDataSource;
import miptjava.service.db.DbInit;
import miptjava.service.db.SimpleJdbcTemplate;

import java.io.IOException;
import java.sql.SQLException;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        var dataSource = new MysqlDataSource();
        dataSource.setUser("newuser");
        dataSource.setPassword("QAZPLMWSXokn1029");
        dataSource.setURL("jdbc:mysql://localhost:3306/cumDb");

        var adapter = new SimpleJdbcTemplate(dataSource);

        var initializer = new DbInit(adapter);
        try {
            initializer.create();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        var uploader = new DataUploader();
        try {
            uploader.uploadAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
