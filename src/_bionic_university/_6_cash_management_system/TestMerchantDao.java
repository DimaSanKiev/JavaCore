package _bionic_university._6_cash_management_system;

import _bionic_university._6_cash_management_system.dao.EntityDao;
import _bionic_university._6_cash_management_system.dao.MerchantDaoImpl;
import _bionic_university._6_cash_management_system.entity.Merchant;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TestMerchantDao {
    public static void main(String[] args) throws IOException, SQLException {
        // select all
        EntityDao<Merchant> merchantDao = new MerchantDaoImpl();
        List<Merchant> merchants;
        merchants = merchantDao.selectAll();
        merchants.forEach(System.out::println);

        // select by id
        System.out.println(merchantDao.selectById(1));

//         create
//        Merchant merchant = new Merchant();
//        merchant.setName("John Smith Ltd.");
//        merchant.setCharge(5.3);
//        merchant.setPeriod(2);
//        merchant.setMinSum(200.0);
//        merchant.setBankName("Deutsche Bank");
//        merchant.setSwift("AB345DDX");
//        merchant.setAccount("548569001");
//        merchantDao.create(merchant);

        // delete by id
//        merchantDao.deleteById(301);

        // update by id
        Merchant merchant1 = new Merchant();
        merchant1.setName("Kelly Larson Ltd.");
        merchant1.setCharge(2.3);
        merchant1.setPeriod(3);
        merchant1.setMinSum(100.0);
        merchant1.setBankName("OTP Bank");
        merchant1.setSwift("AC355DDX");
        merchant1.setAccount("145549009");
        merchantDao.updateById(merchant1, 102);
    }
}
