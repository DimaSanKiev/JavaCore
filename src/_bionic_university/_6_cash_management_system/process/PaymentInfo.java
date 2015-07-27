package _bionic_university._6_cash_management_system.process;

import _bionic_university._6_cash_management_system.dao.EntityDao;
import _bionic_university._6_cash_management_system.dao.JdbcUtils;
import _bionic_university._6_cash_management_system.dao.MerchantDaoImpl;
import _bionic_university._6_cash_management_system.entity.Merchant;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;

public class PaymentInfo {

    public static final String INSERT_PAYMENT = "INSERT INTO payment (dt, merchantid, customerid, goods, sumpayed, chargepayed) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_MERCHANT = "UPDATE merchant m SET needtosend=(SELECT sum(sumPayed - charge) FROM payment p WHERE p.merchantId = m.id) WHERE id=?";

    public static void main(String[] args) throws IOException {
        addPayment(Date.valueOf("2015-07-26"), 1, 1, "Music CD", 15.0);
        addPayment(Date.valueOf(LocalDate.now()), 3, 2, "Dell Monitor", 350.0);
        addPayment(Date.valueOf(LocalDate.now()), 2, 3, "Nexus Cell Phone", 420.0);
        addPayment(Date.valueOf(LocalDate.now()), 1, 4, "HP Printer", 220.0);
        updateMerchant(1);
        updateMerchant(2);
        updateMerchant(3);
        updateMerchant(4);
    }

    public static void updateMerchant(int merchantId) throws IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(UPDATE_MERCHANT);
            ps.setInt(1, merchantId);
            ps.executeUpdate();
            System.out.println("Merchant with id " + merchantId + " was updated.");
        } catch (SQLException e) {
            System.out.println("Cannot execute SQL = '" + UPDATE_MERCHANT + "'" + e);
        } finally {
            JdbcUtils.closeQuitely(ps);
            JdbcUtils.closeQuitely(conn);
        }
    }

    public static void addPayment(Date dt, int customerId, int merchantId, String goods, double sumPayed) throws IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT_PAYMENT);
            ps.setDate(1, dt);
            ps.setInt(2, merchantId);
            ps.setInt(3, customerId);
            ps.setString(4, goods);
            ps.setDouble(5, sumPayed);
            double chargePayed = sumPayed * getCharge(merchantId) / 100;
            ps.setDouble(6, chargePayed);
            ps.executeUpdate();
            System.out.println("New payment added.");
        } catch (SQLException e) {
            System.out.println("Cannot execute SQL = '" + INSERT_PAYMENT + "'" + e);
        } finally {
            JdbcUtils.closeQuitely(ps);
            JdbcUtils.closeQuitely(conn);
        }
    }

    public static double getCharge(int merchantId) throws IOException {
        EntityDao<Merchant> merchantDao = new MerchantDaoImpl();
        Merchant merchant = null;
        try {
            merchant = merchantDao.selectById(merchantId);
        } catch (SQLException e) {
            System.out.println("Cannot get merchant's charge: " + e);
        }
        return merchant.getCharge();
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
}
