package _bionic_university._6_cash_management_system;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Properties;

public class TransferMoney {
    public enum periodEnum {UNKNOWN, WEEKLY, TENDAYS, MONTHLY}

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            TransferMoney t = new TransferMoney();
            ArrayList<MerchantInfo> list = t.getMerchantInfo(conn);
            list = t.filterList(list);
            t.addToTransfer(conn, list);
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    public ArrayList<MerchantInfo> filterList(ArrayList<MerchantInfo> list) {
        ArrayList<MerchantInfo> listRet = new ArrayList<MerchantInfo>();
        for (MerchantInfo info : list) {
            if (info.getMinSum() > info.getSum()) continue;
            Instant instant = Instant.ofEpochMilli(info.getLastSent().getTime());
            LocalDate dt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
            LocalDate current = LocalDate.now();
            switch (info.getPeriod()) {
                case WEEKLY:
                    if (dt.until(current, ChronoUnit.WEEKS) < 1) continue;
                    break;
                case TENDAYS:
                    if (dt.until(current, ChronoUnit.DAYS) < 10) continue;
                    break;
                case MONTHLY:
                    if (dt.until(current, ChronoUnit.MONTHS) < 1) continue;
                    break;
                default:
                    break;
            }
            listRet.add(info);
        }
        return listRet;
    }

    public void addToTransfer(Connection conn, ArrayList<MerchantInfo> list) throws SQLException {
        String sql = "INSERT INTO transMoney(merchantId, sumSent, sentDate, status) VALUES(?,?,?, '0')";
        PreparedStatement stmt = conn.prepareStatement(sql);
        for (MerchantInfo info : list) {
            stmt.setInt(1, info.getId());
            stmt.setDouble(2, info.getSum());
            java.sql.Timestamp dt = new java.sql.Timestamp(new java.util.Date().getTime());
            stmt.setTimestamp(3, dt);
            stmt.executeUpdate();
        }
    }

    public ArrayList<MerchantInfo> getMerchantInfo(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ArrayList<MerchantInfo> list = new ArrayList<MerchantInfo>();
        String sql = "SELECT id, period, needToSend, lastSent, minSum FROM merchant";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            MerchantInfo info = new MerchantInfo();
            info.setId(rs.getInt("id"));
            info.setLastSent(rs.getDate("lastSent"));
            info.setPeriod(periodEnum.values()[rs.getInt("period")]);
            info.setSum(rs.getDouble("needToSend"));
            info.setMinSum(rs.getDouble("minSum"));
            list.add(info);
        }
        return list;
    }

    public static Connection getConnection() throws IOException, SQLException {
        Connection conn = null;
        Properties props = new Properties();
        InputStreamReader in = new InputStreamReader(new FileInputStream("files\\appProperties.txt"), "UTF-8");
        props.load(in);
        in.close();

        String connString = props.getProperty("DBConnectionString");
        conn = DriverManager.getConnection(connString);
        return conn;
    }

    class MerchantInfo {
        private int id;
        private java.sql.Date lastSent;
        private double sum;
        private periodEnum period;
        private double minSum;

        public MerchantInfo() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public java.sql.Date getLastSent() {
            return lastSent;
        }

        public void setLastSent(java.sql.Date lastSent) {
            this.lastSent = lastSent;
        }

        public double getSum() {
            return sum;
        }

        public void setSum(double sum) {
            this.sum = sum;
        }

        public periodEnum getPeriod() {
            return period;
        }

        public double getMinSum() {
            return minSum;
        }

        public void setMinSum(double minSum) {
            this.minSum = minSum;
        }

        public void setPeriod(periodEnum period) {
            this.period = period;
        }

    }
}
