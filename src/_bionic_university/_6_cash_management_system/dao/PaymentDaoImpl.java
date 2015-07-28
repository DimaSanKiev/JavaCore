package _bionic_university._6_cash_management_system.dao;

import _bionic_university._6_cash_management_system.entity.Payment;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PaymentDaoImpl implements EntityDao<Payment> {
    public static final String INSERT = "INSERT INTO payment (dt, merchantid, customerid, goods, sumpayed) VALUES (?, ?, ?, ?, ?)";
    public static final String SELECT_ALL = "SELECT id, dt, merchantid, customerid, goods, sumpayed, chargepayed FROM payment";
    public static final String SELECT_BY_ID = "SELECT id, dt, merchantid, customerid, goods, sumpayed, chargepayed FROM payment WHERE id=?";
    public static final String UPDATE_BY_ID = "UPDATE payment SET dt=?, merchantid=?, customerid=?, goods=?, sumpayed=? WHERE id=?";
    public static final String DELETE_BY_ID = "DELETE FROM payment WHERE id=?";

    @Override
    public List<Payment> selectAll() throws IOException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        List<Payment> result = null;
        try {
            conn = getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(SELECT_ALL);
            result = new ArrayList<>();
            while (rs.next()) {
                Payment payment = new Payment();
                payment.setId(rs.getInt("id"));
                payment.setDate(rs.getDate("dt"));
                payment.setMerchantId(rs.getInt("merchantid"));
                payment.setCustomerId(rs.getInt("customerid"));
                payment.setGoodsDesc(rs.getString("goods"));
                payment.setSumPayed(rs.getDouble("sumpayed"));
                payment.setChargePayed(rs.getDouble("chargepayed"));
                result.add(payment);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot execute SQL = '" + SELECT_ALL + "'" + e);
        } finally {
            JdbcUtils.closeQuitely(rs);
            JdbcUtils.closeQuitely(st);
            JdbcUtils.closeQuitely(conn);
        }
    }

    @Override
    public void create(Payment payment) throws IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setDate(1, payment.getDate());
            ps.setInt(2, payment.getMerchantId());
            ps.setInt(3, payment.getCustomerId());
            ps.setString(4, payment.getGoodsDesc());
            ps.setDouble(5, payment.getSumPayed());
            ps.executeUpdate();

            int affectedRows = ps.executeUpdate();
            System.out.println("Created " + affectedRows + " payment with values " + payment);
        } catch (SQLException e) {
            System.out.println("Cannot execute SQL = '" + INSERT + "'" + e);
        } finally {
            JdbcUtils.closeQuitely(ps);
            JdbcUtils.closeQuitely(conn);
        }
    }

    @Override
    public Payment selectById(int id) throws IOException {
        Payment payment = new Payment();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                payment.setId(rs.getInt("id"));
                payment.setDate(rs.getDate("dt"));
                payment.setMerchantId(rs.getInt("merchantid"));
                payment.setCustomerId(rs.getInt("customerid"));
                payment.setGoodsDesc(rs.getString("goods"));
                payment.setSumPayed(rs.getDouble("sumpayed"));
                payment.setChargePayed(rs.getDouble("chargepayed"));
            }

        } catch (SQLException e) {
            System.out.println("Cannot execute SQL = '" + SELECT_BY_ID + "'" + e);
        } finally {
            JdbcUtils.closeQuitely(rs);
            JdbcUtils.closeQuitely(ps);
            JdbcUtils.closeQuitely(conn);
        }
        return payment;
    }

    @Override
    public void deleteById(int id) throws IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(DELETE_BY_ID);
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            if (result == 0) {
                throw new SQLException("Deleting payment failed, no rows affected.");
            }
            System.out.println("Payment with id " + id + " was deleted.");
        } catch (SQLException e) {
            throw new RuntimeException("Cannot execute SQL = '" + DELETE_BY_ID + id + "'");
        } finally {
            JdbcUtils.closeQuitely(ps);
            JdbcUtils.closeQuitely(conn);
        }
    }

    @Override
    public void updateById(Payment payment, int id) throws IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(UPDATE_BY_ID);
            ps.setDate(1, payment.getDate());
            ps.setObject(2, payment.getMerchantId());
            ps.setObject(3, payment.getCustomerId());
            ps.setString(4, payment.getGoodsDesc());
            ps.setDouble(5, payment.getSumPayed());
            ps.setInt(6, id);
            ps.executeUpdate();
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("Updating payment failed, no rows affected.");
            }
            System.out.println("Payment with id " + id + " was updated.");
        } catch (SQLException e) {
            throw new RuntimeException("Cannot execute SQL = '" + UPDATE_BY_ID + "'", e);
        } finally {
            JdbcUtils.closeQuitely(ps);
            JdbcUtils.closeQuitely(conn);
        }
    }

    public static Connection getConnection() throws IOException, SQLException {
        Connection conn;
        Properties props = new Properties();
        InputStreamReader in = new InputStreamReader(new FileInputStream("files/appProperties.txt"), "UTF-8");
        props.load(in);
        in.close();

        String connString = props.getProperty("DBConnectionString");
        conn = DriverManager.getConnection(connString);
        return conn;
    }
}
