package _bionic_university._6_cash_management_system;

import _bionic_university._6_cash_management_system.dao.CustomerDaoImpl;
import _bionic_university._6_cash_management_system.dao.EntityDao;
import _bionic_university._6_cash_management_system.entity.Customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TestCustomerDao {
    public static void main(String[] args) throws IOException, SQLException {
        // select all
        EntityDao<Customer> customerDao = new CustomerDaoImpl();
        List<Customer> customers;
        customers = customerDao.selectAll();
        customers.forEach(System.out::println);

        // select by id
        System.out.println(customerDao.selectById(1));

        // create
//        Customer customer = new Customer();
//        customer.setName("John Smith Ltd.");
//        customer.setAddress("Glory Ave. 2, New York, USA");
//        customer.setEmail("john@yahoo.com");
//        customer.setCardNum("41412359878722");
//        customer.setCardType("Visa");
//        customer.setMaturity(Date.valueOf("2018-10-25"));
//        customerDao.create(customer);

        // delete by id
//        customerDao.deleteById(201);

        // update by id
//        Customer customer1 = new Customer();
//        customer1.setName("Kelly Larson Ltd.");
//        customer1.setAddress("Newton Str. 16, London, England");
//        customer1.setEmail("kelly@yahoo.com");
//        customer1.setCardNum("4258780045963221");
//        customer1.setCardType("Maestro");
//        customer1.setMaturity(Date.valueOf("2019-01-05"));
//        customerDao.updateById(customer1, 202);
    }
}
