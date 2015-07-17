package _bionic_university._2_bank;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class MainDepoToFile {
    public static void main(String[] args) throws IOException {
        DepoList test0 = new DepoList();
        test0.init();
        ArrayList<Depo> list0 = test0.getList();
        Collections.sort(list0);

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("depo.txt")))) {
            for (Depo depo : list0) {
                String str = String.format("sum = %1$8.2f   interest =  %2$7.2f\n", depo.getSum(), depo.getIncome());
                writer.write(str);
            }
            System.out.println("Report depo.txt successfully created.");
        }
    }
}
