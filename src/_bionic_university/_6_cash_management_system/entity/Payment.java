package _bionic_university._6_cash_management_system.entity;

import java.util.Date;

public class Payment {
    private int id;
    private Date date;
    private Customer customer;
    private Merchant merchant;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
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
}
