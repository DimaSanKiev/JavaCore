package _bionic_university._6_cash_management_system.entity;

public class Merchant {
    private int id;
    private String name;
    private double charge;
    private int period;
    private double needToSend;

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

    public String toString() {
        String txt = "id = " + id + ";   name = '" + name + "';   charge = ";
        txt += "" + charge + ";   period = " + period + ";   total = " + needToSend;
        return txt;
    }

}
