package _bionic_university._2_bank;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class MainDepoToFile {
    public static void main(String[] args) throws IOException {
        DepoList test = new DepoList();
        test.init();
        ArrayList<Depo> list0 = test.getList();
        Collections.sort(list0);

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("files/depo.txt")))) {
            for (Depo depo : list0) {
                String str = String.format("sum = %1$8.2f   interest =  %2$7.2f\n", depo.getSum(), depo.getIncome());
                writer.write(str);
            }
            System.out.println("Report depo.txt successfully created.");
        }
    }
}
