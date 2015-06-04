package java_io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SumOfNumbersFromConsole {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        System.out.println("Please input numbers to sum, type 'exit' when finish.");
        while (true) {
            String z = reader.readLine();
            if (z.equals("exit")) {
                System.out.println("Sum of your numbers is: " + sum);
                return;
            } else {
                sum = sum + Integer.parseInt(z);
            }
        }
    }
}
