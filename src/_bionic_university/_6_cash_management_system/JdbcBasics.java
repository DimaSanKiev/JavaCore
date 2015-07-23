package _bionic_university._6_cash_management_system;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class JdbcBasics {
    public static void main(String[] args) throws IOException, SQLException {
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

        Connection con = getConnection();
        String sql = "INSERT INTO customer (name, address, ";
        sql += " email, ccNo, ccType, maturity) values(";
        sql += " 'Clar Nelis', 'Vosselaar st. 19, Trnaut, Belgium', ";
        sql += " 'Clar@adw.com', 	'11345694671231', ";
        sql += " 'MasterCard', '2014-07-31') ";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(sql);
        con.close();

    }

    public static Connection getConnection() throws IOException, SQLException {
        Connection conn = null;
        Properties props = new Properties();
        InputStreamReader in = new InputStreamReader(new FileInputStream("files/appProperties.txt"), "UTF-8");
        props.load(in);
        in.close();

        String connString = props.getProperty("DBConnectionString");
        conn = DriverManager.getConnection(connString);
        return conn;
    }

}
