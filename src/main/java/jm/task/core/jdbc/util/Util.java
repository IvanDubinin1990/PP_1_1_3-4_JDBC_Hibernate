package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String userName = "bestuser";
    private static final String userPassword = "bestuser";
    private static final String connectionURL = "jdbc:mysql://localhost:3306/mynewdb";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, userName, userPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
