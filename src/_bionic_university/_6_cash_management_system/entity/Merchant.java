package _bionic_university._6_cash_management_system.entity;

import java.sql.Date;

public class Merchant {
    private int id;
    private String name;
    private double charge;
    private int period;
    private double minSum;
    private String bankName;
    private String swift;
    private String account;
    private double needToSend;
    private double sent;
    private Date laseSent;

    public Merchant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getNeedToSend() {
        return needToSend;
    }

    public void setNeedToSend(double needToSend) {
        this.needToSend = needToSend;
    }

    public double getMinSum() {
        return minSum;
    }

    public void setMinSum(double minSum) {
        this.minSum = minSum;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getSent() {
        return sent;
    }

    public void setSent(double sent) {
        this.sent = sent;
    }

    public Date getLastSent() {
        return laseSent;
    }

    public void setLaseSent(Date laseSent) {
        this.laseSent = laseSent;
    }

    public String toString() {
        String txt = "id = " + id + ";   name = '" + name + "';   charge = ";
        txt += "" + charge + ";   period = " + period + ";   total = " + needToSend;
        return txt;
    }

}
