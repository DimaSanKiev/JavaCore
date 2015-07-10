package _bionic_university._2_bank;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        DepoList test0 = new DepoList();
        test0.init();
        ArrayList<Depo> list0 = test0.getList();
        Collections.sort(list0);
        for (Depo depo : list0) {
            System.out.format("sum = %1$8.2f   interest =  %2$7.2f\n", depo.getSum(), depo.getIncome());
        }
        System.out.println();

        DepoList test1 = new DepoList();
        test1.init();
        ArrayList<Depo> list1 = test1.getList();
        Collections.sort(list1, new DepoComparator());
        for (Depo depo : list1) {
            System.out.format("sum = %1$8.2f   interest =  %2$7.2f\n", depo.getSum(), depo.getIncome());
        }

    }
}
