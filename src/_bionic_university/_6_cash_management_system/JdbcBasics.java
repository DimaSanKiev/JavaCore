package _bionic_university._6_cash_management_system;

import java.sql.*;

public class JdbcBasics {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby:MyDB");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT name, charge FROM merchant");
            while (rs.next()) {
                String nm = rs.getString("name");
                double p = rs.getDouble(2);
                System.out.println(nm + "   " + p);
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
