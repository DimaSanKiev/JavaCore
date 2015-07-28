package _bionic_university._6_cash_management_system;

import _bionic_university._6_cash_management_system.dao.EntityDao;
import _bionic_university._6_cash_management_system.dao.PaymentDaoImpl;
import _bionic_university._6_cash_management_system.entity.Payment;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TestPaymentDao {
    public static void main(String[] args) throws IOException, SQLException {
        // select all
        EntityDao<Payment> paymentDao = new PaymentDaoImpl();
        List<Payment> payments;
        payments = paymentDao.selectAll();
        payments.forEach(System.out::println);

        // select by id
        System.out.println(paymentDao.selectById(1));

        // create
//        Payment payment = new Payment();
//        payment.setDate(Date.valueOf("2015-07-25"));
//        payment.setMerchantId(3);
//        payment.setCustomerId(1);
//        payment.setGoodsDesc("PC services");
//        payment.setSumPayed(550.0);
//        paymentDao.create(payment);

        // delete by id
//        paymentDao.deleteById(502);

        // update by id
//        Payment payment1 = new Payment();
//        payment1.setDate(Date.valueOf("2015-07-26"));
//        payment1.setMerchantId(3);
//        payment1.setCustomerId(1);
//        payment1.setGoodsDesc("Server services");
//        payment1.setSumPayed(100.0);
//        paymentDao.updateById(payment1, 501);
    }
}
