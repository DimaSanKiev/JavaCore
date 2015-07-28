package _bionic_university._6_cash_management_system.dao;

import _bionic_university._6_cash_management_system.entity.Customer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CustomerDaoImpl implements EntityDao<Customer> {
    public static final String INSERT = "INSERT INTO customer (name, address, email, ccno, cctype, maturity) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String SELECT_ALL = "SELECT id, name, address, email, ccno, cctype, maturity FROM customer";
    public static final String SELECT_BY_ID = "SELECT id, name, address, email, ccno, cctype, maturity FROM customer WHERE id=?";
    public static final String UPDATE_BY_ID = "UPDATE customer SET name=?, address=?, email=?, ccno=?, cctype=?, maturity=? WHERE id=?";
    public static final String DELETE_BY_ID = "DELETE FROM customer WHERE id=?";

    @Override
    public List<Customer> selectAll() throws IOException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        List<Customer> result = null;
        try {
            conn = getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(SELECT_ALL);
            result = new ArrayList<>();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setAddress(rs.getString("address"));
                customer.setEmail(rs.getString("email"));
                customer.setCardNum(rs.getString("ccno"));
                customer.setCardType(rs.getString("cctype"));
                customer.setMaturity(rs.getDate("maturity"));
                result.add(customer);
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
    public void create(Customer customer) throws IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getCardNum());
            ps.setString(5, customer.getCardType());
            ps.setDate(6, customer.getMaturity());
            ps.executeUpdate();

            int affectedRows = ps.executeUpdate();
            System.out.println("Created " + affectedRows + " customer with values " + customer);
        } catch (SQLException e) {
            System.out.println("Cannot execute SQL = '" + INSERT + "'" + e);
        } finally {
            JdbcUtils.closeQuitely(ps);
            JdbcUtils.closeQuitely(conn);
        }
    }

    @Override
    public Customer selectById(int id) throws IOException {
        Customer customer = new Customer();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setAddress(rs.getString("address"));
                customer.setEmail(rs.getString("email"));
                customer.setCardNum(rs.getString("ccno"));
                customer.setCardType(rs.getString("cctype"));
                customer.setMaturity(rs.getDate("maturity"));
            }

        } catch (SQLException e) {
            System.out.println("Cannot execute SQL = '" + SELECT_BY_ID + "'" + e);
        } finally {
            JdbcUtils.closeQuitely(rs);
            JdbcUtils.closeQuitely(ps);
            JdbcUtils.closeQuitely(conn);
        }
        return customer;
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
                throw new SQLException("Deleting customer failed, no rows affected.");
            }
            System.out.println("Customer with id " + id + " was deleted.");
        } catch (SQLException e) {
            throw new RuntimeException("Cannot execute SQL = '" + DELETE_BY_ID + id + "'" + e.getMessage());
        } finally {
            JdbcUtils.closeQuitely(ps);
            JdbcUtils.closeQuitely(conn);
        }
    }

    @Override
    public void updateById(Customer customer, int id) throws IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(UPDATE_BY_ID);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getCardNum());
            ps.setString(5, customer.getCardType());
            ps.setDate(6, customer.getMaturity());
            ps.setInt(7, id);
            ps.executeUpdate();
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("Updating customer failed, no rows affected.");
            }
            System.out.println("Customer with id " + id + " was updated.");
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
