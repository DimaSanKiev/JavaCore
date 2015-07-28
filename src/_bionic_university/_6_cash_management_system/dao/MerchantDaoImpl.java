package _bionic_university._6_cash_management_system.dao;

import _bionic_university._6_cash_management_system.entity.Merchant;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MerchantDaoImpl implements EntityDao<Merchant> {
    public static final String INSERT = "INSERT INTO merchant (name, charge, period, minSum, bankName, swift, account) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_ALL = "SELECT id, name, charge, period, minsum, bankname, swift, account, needtosend, sent, lastsent FROM merchant";
    public static final String SELECT_BY_ID = "SELECT id, name, charge, period, minsum, bankname, swift, account, needtosend, sent, lastsent FROM merchant WHERE id=?";
    public static final String UPDATE_BY_ID = "UPDATE merchant SET name=?, charge=?, period=?, minsum=?, bankname=?, swift=?, account=?, needtosend=?, sent=?, lastsent=? WHERE id=?";
    public static final String DELETE_BY_ID = "DELETE FROM merchant WHERE id=?";

    @Override
    public List<Merchant> selectAll() throws IOException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        List<Merchant> result = null;
        try {
            conn = getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(SELECT_ALL);
            result = new ArrayList<>();
            while (rs.next()) {
                Merchant merchant = new Merchant();
                merchant.setId(rs.getInt("id"));
                merchant.setName(rs.getString("name"));
                merchant.setCharge(rs.getDouble("charge"));
                merchant.setPeriod(rs.getInt("period"));
                merchant.setMinSum(rs.getDouble("minsum"));
                merchant.setBankName(rs.getString("bankName"));
                merchant.setSwift(rs.getString("swift"));
                merchant.setAccount(rs.getString("account"));
                merchant.setNeedToSend(rs.getDouble("needtosend"));
                merchant.setSent(rs.getDouble("sent"));
                merchant.setLaseSent(rs.getDate("lastsent"));
                result.add(merchant);
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
    public void create(Merchant merchant) throws IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, merchant.getName());
            ps.setDouble(2, merchant.getCharge());
            ps.setInt(3, merchant.getPeriod());
            ps.setDouble(4, merchant.getMinSum());
            ps.setString(5, merchant.getBankName());
            ps.setString(6, merchant.getSwift());
            ps.setString(7, merchant.getAccount());
            ps.executeUpdate();

            int affectedRows = ps.executeUpdate();
            System.out.println("Created " + affectedRows + " merchant with values " + merchant);
        } catch (SQLException e) {
            System.out.println("Cannot execute SQL = '" + INSERT + "'" + e);
        } finally {
            JdbcUtils.closeQuitely(ps);
            JdbcUtils.closeQuitely(conn);
        }
    }

    @Override
    public Merchant selectById(int id) throws IOException {
        Merchant merchant = new Merchant();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                merchant.setId(rs.getInt("id"));
                merchant.setName(rs.getString("name"));
                merchant.setCharge(rs.getDouble("charge"));
                merchant.setPeriod(rs.getInt("period"));
                merchant.setMinSum(rs.getDouble("minsum"));
                merchant.setBankName(rs.getString("bankName"));
                merchant.setSwift(rs.getString("swift"));
                merchant.setAccount(rs.getString("account"));
                merchant.setNeedToSend(rs.getDouble("needtosend"));
                merchant.setSent(rs.getDouble("sent"));
                merchant.setLaseSent(rs.getDate("lastsent"));
            }

        } catch (SQLException e) {
            System.out.println("Cannot execute SQL = '" + SELECT_BY_ID + "'" + e);
        } finally {
            JdbcUtils.closeQuitely(rs);
            JdbcUtils.closeQuitely(ps);
            JdbcUtils.closeQuitely(conn);
        }
        return merchant;
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
                throw new SQLException("Deleting merchant failed, no rows affected.");
            }
            System.out.println("Merchant with id " + id + " was deleted.");
        } catch (SQLException e) {
            throw new RuntimeException("Cannot execute SQL = '" + DELETE_BY_ID + id + "'");
        } finally {
            JdbcUtils.closeQuitely(ps);
            JdbcUtils.closeQuitely(conn);
        }
    }

    @Override
    public void updateById(Merchant merchant, int id) throws IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(UPDATE_BY_ID);
            ps.setString(1, merchant.getName());
            ps.setDouble(2, merchant.getCharge());
            ps.setInt(3, merchant.getPeriod());
            ps.setDouble(4, merchant.getMinSum());
            ps.setString(5, merchant.getBankName());
            ps.setString(6, merchant.getSwift());
            ps.setString(7, merchant.getAccount());
            ps.setDouble(8, merchant.getNeedToSend());
            ps.setDouble(9, merchant.getSent());
            ps.setDate(10, merchant.getLastSent());
            ps.setInt(11, id);
            ps.executeUpdate();
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("Updating merchant failed, no rows affected.");
            }
            System.out.println("Merchant with id " + id + " was updated.");
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
