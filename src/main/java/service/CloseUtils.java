package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CloseUtils {
    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
    }

    public static void closeStatement(Statement statement) throws SQLException {
        if (statement != null) {
            statement.close();
        }
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void closeResources(PreparedStatement preparedStatement, Connection connection) {
        try {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to close resources");
        }
    }

    public static void closeResources(Statement statement, Connection connection) {
        try {
            closeStatement(statement);
            closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to close resources");
        }
    }
}
