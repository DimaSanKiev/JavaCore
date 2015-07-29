package _bionic_university._6_cash_management_system.process;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class Payments {

    public static void main(String[] args) {
        try {
            Connection conn = null;
            try {
                conn = getConnection();
                int merchantId = 1;
                int customerId = 2;
                java.util.Date dt = new java.util.Date();
                String goods = "Dell Monitors";
                double sum = 350.0;
                addPayment(conn, dt, customerId, merchantId, goods, sum);
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
                if (conn != null)
                    conn.rollback();
            } finally {
                if (conn != null)
                    conn.close();
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        System.out.println("New payment was added");
    }

    public static void addPayment(Connection conn, java.util.Date dt,
                                  int customerId, int merchantId, String goods, double sum) throws SQLException {
        double charge = getCharge(conn, merchantId);
        if (charge < 0.0)
            return;

        conn.setAutoCommit(false);
        String sqlIns = "INSERT INTO payment(dt, customerId, merchantId, goods, sumPayed, chargePayed) VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement ps1 = conn.prepareStatement(sqlIns);
        java.sql.Timestamp timestamp = new java.sql.Timestamp(dt.getTime());
        ps1.setTimestamp(1, timestamp);
        ps1.setInt(2, customerId);
        ps1.setInt(3, merchantId);
        ps1.setString(4, goods);
        ps1.setDouble(5, sum);
        double p = Math.round(sum * charge) / 100.0;
        ps1.setDouble(6, p);
        ps1.executeUpdate();

        String sqlUpdt = "UPDATE merchant SET needToSend = needToSend + ? WHERE id = ?";
        PreparedStatement ps2 = conn.prepareStatement(sqlUpdt);
        double s = sum - p;
        ps2.setDouble(1, s);
        ps2.setInt(2, merchantId);
        ps2.executeUpdate();
        conn.commit();
    }

    public static double getCharge(Connection conn, int merchantId)
            throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT charge FROM merchant where id = "+ merchantId);
        if (!rs.next())
            return -1.0;
        double ret = rs.getDouble("charge");
        rs.close();
        stmt.close();
        return ret;
    }

    public static Connection getConnection() throws IOException, SQLException {
        Connection conn;
        Properties props = new Properties();
        InputStreamReader in = new InputStreamReader(new FileInputStream("files\\appProperties.txt"), "UTF-8");
        props.load(in);
        in.close();

        String connString = props.getProperty("DBConnectionString");
        conn = DriverManager.getConnection(connString);
        return conn;
    }

}
