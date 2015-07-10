package _bionic_university._2_bank;

import java.util.Comparator;

public class DepoComparator implements Comparator<Depo> {

    public int compare(Depo depo1, Depo depo2) {
        if (depo1.getSum() > depo2.getSum()) return 1;
        if (depo1.getSum() < depo2.getSum()) return -1;
        return 0;
    }

}
