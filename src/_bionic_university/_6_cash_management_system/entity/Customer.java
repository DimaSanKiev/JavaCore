package _bionic_university._6_cash_management_system.entity;

import java.sql.Date;

public class Customer {
    private int id;
    private String name;
    private String address;
    private String email;
    private String cardNum;
    private String cardType;
    private Date maturity;

    public Customer() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Date getMaturity() {
        return maturity;
    }

    public void setMaturity(Date maturity) {
        this.maturity = maturity;
    }

    public String toString() {
        String txt = "id = " + id + ";   name = '" + name + "';   address = ";
        txt += "" + address + ";   email = " + email;
        return txt;
    }
}
