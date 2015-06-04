package procedural_java;

/*
This code:
1. Creates an array of random int values (from 0 to 100);
2. Outputs the maximal value.
3. Outputs the minimal value.
 */

import java.io.IOException;

public class MaxMinAverageValueFromArray {
    public static void main(String[] args) throws Exception {
        int[] array = initializeRandomArray();
        int max = max(array);
        int min = min(array);
        double average = average(array);
        System.out.println("Maximal value is: " + max);
        System.out.println("Minimal value is: " + min);
        System.out.println("Average value is: " + average);
    }

    public static int[] initializeRandomArray() throws IOException {
        int array[] = new int[20];
        System.out.print("Generated array is: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        return array;
    }

    public static int max(int[] array) {
        int max = array[0];
        for (int i : array) {
            if (i > max) max = i;
        }
        return max;
    }

    public static int min(int[] array) {
        int min = array[0];
        for (int i : array) {
            if (i < min) min = i;
        }
        return min;
    }

    private static double average(int[] array) {
        double sum = 0;
        for (int anArray : array) {
            sum += anArray;
        }
        return sum / array.length;
    }
}
