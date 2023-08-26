package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.util.Objects.isNull;

public class Database {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (isNull(connection) || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
        }

        return connection;
    }
}
