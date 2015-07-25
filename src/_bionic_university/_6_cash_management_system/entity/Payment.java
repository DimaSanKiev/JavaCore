package _bionic_university._6_cash_management_system.entity;

import java.sql.Date;

public class Payment {
    private int id;
    private Date date;
    private int customerId;
    private int merchantId;
    private String goodsDesc;
    private double sumPayed;
    private double chargePayed;

    public Payment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public double getSumPayed() {
        return sumPayed;
    }

    public void setSumPayed(double sumPayed) {
        this.sumPayed = sumPayed;
    }

    public double getChargePayed() {
        return chargePayed;
    }

    public void setChargePayed(double chargePayed) {
        this.chargePayed = chargePayed;
    }

    public String toString() {
        String txt = "id = " + id + ";   date = '" + date + "';   merchant_id = ";
        txt += "" + merchantId + ";   customer_id = " + customerId;
        txt += ";   sum_payed = " + sumPayed + ";   charge_payed = " + chargePayed;
        return txt;
    }
}
