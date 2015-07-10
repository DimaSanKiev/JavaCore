package _bionic_university._2_bank;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        DepoList test = new DepoList();
        test.init();
        ArrayList<Depo> list = test.getList();
        Collections.sort(list);
        for (Depo depo : list) {
            System.out.format("sum = %1$8.2f   interest =  %2$7.2f\n", depo.getSum(), depo.getIncome());
        }
    }
}
