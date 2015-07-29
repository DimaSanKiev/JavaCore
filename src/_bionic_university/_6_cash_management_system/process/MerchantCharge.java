package _bionic_university._6_cash_management_system.process;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class MerchantCharge {

    public static void main(String[] args) {
        try{
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT m.name, SUM(p.chargePayed) AS charge FROM payment p,";
            sql += "merchant m WHERE m.id=p.merchantId GROUP BY m.name";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                System.out.format("%1$25s  %2$8.2f \n", rs.getString("name"), rs.getDouble("charge"));
            }
            conn.close();
        } catch(Exception ex){
            System.out.println("Error " + ex.getMessage());
        }
    }

    public static Connection getConnection() throws IOException, SQLException{
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
