package _bionic_university._6_cash_management_system;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Properties;

public class JdbcBasics {
    public static void main(String[] args) throws IOException, SQLException {
        preparedInsert();
    }

    public static void preparedInsert() {
        try {
            Connection con = getConnection();
            String sql = "INSERT INTO customer (name, address, ";
            sql += " email, ccNo, ccType, maturity) values(";
            sql += " 'Clar Nelis', 'Vosselaar st. 19, Trnaut, Belgium', ";
            sql += " 'Clar@adw.com', 	'11345694671231', ";
            sql += " 'MasterCard', '2014-07-31') ";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            con.close();
            System.out.println("New record was inserted");
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }


    public static void simpleInsert() {
        try {
            LocalDate dt1 = LocalDate.of(2015, 2, 15);
            Instant instant = dt1.atStartOfDay(ZoneId.systemDefault()).toInstant();
            java.sql.Date dt = new java.sql.Date(java.util.Date.from(instant).getTime());
            addCustomer("Willy Nest", "Mountain View, California", "wnest@alpha.com",
                    "54664423893279", "Visa", dt);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    public static void addCustomer(String name, String address, String email, String ccNo, String ccType, java.sql.Date dt) throws SQLException, IOException {
        Connection con = getConnection();
        String sql = "INSERT INTO customer (name, address, ";
        sql += " email, ccNo, ccType, maturity) values(?,?,?,?,?,?) ";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, address);
        stmt.setString(3, email);
        stmt.setString(4, ccNo);
        stmt.setString(5, ccType);
        stmt.setDate(6, dt);
        stmt.executeUpdate();
        con.close();
        System.out.println("New record was inserted");
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
