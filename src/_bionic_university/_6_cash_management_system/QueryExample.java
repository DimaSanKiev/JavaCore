package _bionic_university._6_cash_management_system;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class QueryExample {

    public static void main(String[] args) {
        try {
            int len = args.length;
            if (len == 0) return;
            int id = Integer.valueOf(args[0]);
            Connection con = getConnection();
            String sql = "select sum(sumPayed) from PAYMENT where merchantId=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            double sum = rs.getDouble(1);
            con.close();
            System.out.println(sum);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
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
