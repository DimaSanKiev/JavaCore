package _bionic_university._6_cash_management_system.process;

import _bionic_university._6_cash_management_system.entity.Merchant;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class MerchantList {

    public static void main(String[] args) {
        try{
            Connection conn = getConnection();
            ArrayList<Merchant> mer = getMerchants(conn);
            int count = mer.size();
            for (int i = 0; i < count; i++){
                String txt = mer.get(i).toString();
                System.out.println(txt);
            }
            conn.close();
        }
        catch(SQLException ex){
            System.out.println("Error " + ex.getMessage());
        }
        catch(Exception ex){
            System.out.println("Error " + ex.getMessage());
        }
    }

    public static ArrayList<Merchant> getMerchants(Connection conn) throws SQLException{
        ArrayList<Merchant> ret = new ArrayList<Merchant>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name, charge, period, needToSend FROM merchant");
        while (rs.next()){
            Merchant m = new Merchant();
            m.setId(rs.getInt("id"));
            m.setName(rs.getString("name"));
            m.setCharge(rs.getDouble("charge"));
            m.setPeriod(rs.getInt("period"));
            m.setNeedToSend(rs.getDouble("needToSend"));
            ret.add(m);
        }
        return ret;
    }

    public static Connection getConnection() throws	IOException, SQLException{
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
