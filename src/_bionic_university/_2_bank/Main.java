package _bionic_university._2_bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        DepoList test0 = new DepoList();
        test0.init();
        ArrayList<Depo> list0 = test0.getList();
        Collections.sort(list0);

        for (Depo depo : list0) {
            String str = String.format("sum = %1$8.2f   interest =  %2$7.2f\n", depo.getSum(), depo.getIncome());
            System.out.format(str);
            try {
                Files.write(Paths.get("depo.txt"), str.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
/*
        // Comparable
        DepoList test0 = new DepoList();
        test0.init();
        ArrayList<Depo> list0 = test0.getList();
        Collections.sort(list0);
        for (Depo depo : list0) {
            System.out.format("sum = %1$8.2f   interest =  %2$7.2f\n", depo.getSum(), depo.getIncome());
        }
        System.out.println();

        // DepoComparator
        DepoList test1 = new DepoList();
        test1.init();
        ArrayList<Depo> list1 = test1.getList();
        Collections.sort(list1, new DepoComparator());
        for (Depo depo : list1) {
            System.out.format("sum = %1$8.2f   interest =  %2$7.2f\n", depo.getSum(), depo.getIncome());
        }
        System.out.println();

        // Depo.DepoComparator
        DepoList test2 = new DepoList();
        test2.init();
        ArrayList<Depo> list2 = test2.getList();
        Collections.sort(list2, new Depo.DepoComparator());
        for (Depo depo : list2) {
            System.out.format("sum = %1$8.2f   interest =  %2$7.2f\n", depo.getSum(), depo.getIncome());
        }
        System.out.println();

        // lambda
        DepoList test3 = new DepoList();
        test3.init();
        ArrayList<Depo> list3 = test3.getList();
        list3.sort((depo1, depo2) -> (int) (depo1.getSum() * 100 - depo2.getSum() * 100));
        for (Depo depo : list3) {
            System.out.format("sum = %1$8.2f   interest = %2$7.2f\n",
                    depo.getSum(), depo.getIncome());
        }
        System.out.println();

        // forEach
        DepoList test4 = new DepoList();
        test4.init();
        ArrayList<Depo> list4 = test4.getList();
        list4.forEach(d -> System.out.format("sum = %1$8.2f   interest = %2$7.2f\n", d.getSum(), d.getIncome()));
        System.out.println();

        // streamForEach
        DepoList test5 = new DepoList();
        test5.init();
        ArrayList<Depo> list5 = test5.getList();
        list5
                .stream()
                .forEach(d -> System.out.format("sum = %1$8.2f   interest = %2$7.2f\n", d.getSum(), d.getIncome()));
        System.out.println();

        // pipeline
        DepoList test6 = new DepoList();
        test6.init();
        ArrayList<Depo> list6 = test6.getList();
        list6
                .stream()
                .filter(d -> d.getInterestRate() > 16.5)
                .forEach(d -> System.out.format("sum = %1$8.2f   interestRate = %2$7.2f\n", d.getSum(), d.getInterestRate()));
        System.out.println();

        // average
        DepoList test7 = new DepoList();
        test7.init();
        ArrayList<Depo> list7 = test7.getList();
        double avg = list7
                .stream()
                .filter(d -> d.getInterestRate() > 16.5)
                .mapToDouble(Depo::getSum)
                .average()
                .getAsDouble();
        System.out.println("Average sum = " + avg);
        System.out.println();

        // reduce
        DepoList test8 = new DepoList();
        test8.init();
        ArrayList<Depo> list8 = test8.getList();
        double sum = list8
                .stream()
                .mapToDouble(Depo::getSum)
                .reduce(0, (a, b) -> a + b);
        System.out.println("General sum = " + sum);
        System.out.println();

        // collect
        DepoList test9 = new DepoList();
        test9.init();
        ArrayList<Depo> list9 = test9.getList();
        ArrayList<Depo> largeSum = (ArrayList<Depo>) list9
                .stream()
                .filter(d -> d.getSum() > 10000.0)
                .collect(Collectors.toList());
        largeSum.forEach(d -> System.out.format("sum = %1$8.2f   interest = %2$7.2f\n", d.getSum(), d.getIncome()));
    */
    }
}
