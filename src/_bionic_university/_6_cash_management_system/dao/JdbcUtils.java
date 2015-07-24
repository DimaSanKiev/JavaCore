package _bionic_university._6_cash_management_system.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {

    public static void closeQuitely(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("Closing ResultSet failed: " + e.getMessage());
            }
        }
    }

    public static void closeQuitely(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Closing Statement failed: " + e.getMessage());
            }
        }
    }

    public static void closeQuitely(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Closing Connection failed: " + e.getMessage());
            }
        }
    }
}
