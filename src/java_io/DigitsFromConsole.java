package java_io;

/*
This program:
1. Inputs from console number N > 0
2. Then inputs N numbers from console
3. Output the maximum from N.
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DigitsFromConsole {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input numbers quantity:");
        int N = Integer.parseInt(reader.readLine());
        System.out.println("Now input numbers to calculate maximum:");
        int maximum = Integer.parseInt(reader.readLine());
        int current;

        for (int i = 0; i < N - 1; i++) {
            current = Integer.parseInt(reader.readLine());
            maximum = max(current, maximum);
        }

        System.out.println("The maximum number is: " + maximum);
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

}