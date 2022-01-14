package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/shop";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "xw3!m%f7";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection OK!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection ERROR!");
        }
        return connection;
    }
}
