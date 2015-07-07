package _bionic_university._3_collections;

import _bionic_university._2_bank.Depo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DepositList {
    List<Depo> deposits = new ArrayList<Depo>();
    private ArrayList<Depo> list;

    public void init() {
        deposits.add(new Depo(LocalDate.of(2015, 6, 8), 61, 2500, 18.0));
        deposits.add(new Depo(LocalDate.of(2015, 2, 1), 181, 10000, 21.0));
        deposits.add(new Depo(LocalDate.of(2015, 6, 12), 30, 5500, 15.3));
        deposits.add(new Depo(LocalDate.of(2014, 12, 18), 370, 43000, 19.56));
        deposits.add(new Depo(LocalDate.of(2015, 7, 12), 91, 12000, 16.0));
    }

    public double getPrincipal() {
        double result = 0;
        for (Depo dep : deposits) {
            result += dep.getSum();
        }
        return result;
    }

    public void remove() {
        Iterator<Depo> iter = deposits.iterator();
        while (iter.hasNext()) {
            if (iter.next().getSum() < 10000.0) {
                iter.remove();
            }
        }
    }

    public ArrayList<Depo> getList() {
        return list;
    }
}

