package _bionic_university._6_cash_management_system;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class TransferMain {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        try {
            double sum = Double.valueOf(args[0]);
            conn = getConnection();
            TransferMain transfer = new TransferMain();
            ArrayList<TransferInfo> list = transfer.getUnpayed(conn);
            transfer.procUnpayed(conn, list, sum);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (conn != null) conn.close();
        }
    }

    public void procUnpayed(Connection conn, ArrayList<TransferInfo> list, double sum) throws SQLException {
        double sentSum = 0.0;
        for (TransferInfo info : list) {
            if (sentSum + info.getSumSent() > sum) continue;
            sentSum += info.getSumSent();
            try {
                conn.setAutoCommit(false);
                sendPayment(conn, info);
                updateMerchant(conn, info);
                conn.commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                conn.rollback();
            }
        }
    }

    public void updateMerchant(Connection conn, TransferInfo info) throws SQLException {
        String sql = "SELECT needToSend, sent FROM merchant WHERE id=?";
        PreparedStatement stmtRead = conn.prepareStatement(sql);
        stmtRead.setInt(1, info.getMerchantId());
        ResultSet rs = stmtRead.executeQuery();
        rs.next();
        double needToSend = rs.getDouble("needToSend");
        double sent = rs.getDouble("sent");

        sql = "UPDATE merchant SET lastSent=?, needToSend=?, sent=? WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        java.sql.Timestamp dt = new java.sql.Timestamp(new java.util.Date().getTime());
        stmt.setTimestamp(1, dt);
        stmt.setDouble(2, needToSend - info.getSumSent());
        stmt.setDouble(3, sent + info.getSumSent());
        stmt.setInt(4, info.merchantId);
        stmt.executeUpdate();

    }

    public void sendPayment(Connection conn, TransferInfo info) throws SQLException {
        String sql = "UPDATE transMoney SET sentDate=?, status='1' WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        java.sql.Timestamp dt = new java.sql.Timestamp(new java.util.Date().getTime());
        stmt.setTimestamp(1, dt);
        stmt.setInt(2, info.getId());
        stmt.executeUpdate();
    }

    public ArrayList<TransferInfo> getUnpayed(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ArrayList<TransferInfo> list = new ArrayList<TransferInfo>();
        String sql = "SELECT id, merchantId, sumSent, sentDate, status FROM transMoney WHERE status='0' ORDER BY sentDate, sumSent";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            TransferInfo info = new TransferInfo();
            info.setId(rs.getInt("id"));
            info.setMerchantId(rs.getInt("merchantId"));
            info.setSumSent(rs.getDouble("sumSent"));
            info.setSentDate(rs.getDate("sentDate"));
            info.setStatus(rs.getString("status"));
            list.add(info);
        }
        return list;
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

    class TransferInfo {
        private int id;
        private int merchantId;
        private double sumSent;
        private java.sql.Date sentDate;
        private String status;

        public TransferInfo() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(int merchantId) {
            this.merchantId = merchantId;
        }

        public double getSumSent() {
            return sumSent;
        }

        public void setSumSent(double sumSent) {
            this.sumSent = sumSent;
        }

        public java.sql.Date getSentDate() {
            return sentDate;
        }

        public void setSentDate(java.sql.Date sentDate) {
            this.sentDate = sentDate;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }
}
