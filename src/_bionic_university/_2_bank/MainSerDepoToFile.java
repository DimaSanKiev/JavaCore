package _bionic_university._2_bank;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainSerDepoToFile {
    public static void main(String[] args) throws IOException {
        DepoList test0 = new DepoList();
        test0.init();
        test0.save("depo.txt");
        test0 = new DepoList();
        test0.read("depo.txt");
        ArrayList<Depo> list = test0.getList();
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("depo.txt")))) {
            for (Depo depo : list) {
                String str = String.format("sum = %1$8.2f   interest =  %2$7.2f\n", depo.getSum(), depo.getIncome());
                writer.write(str);
            }
        }
    }
}
