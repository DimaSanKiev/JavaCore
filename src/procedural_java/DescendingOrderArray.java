package procedural_java;


/*
This code:
1. Creates an array of random int values (from 0 to 100);
2. Outputs the array in descending order.
*/

public class DescendingOrderArray {
    public static void main(String[] args) throws Exception {
        int[] array = new int[20];
        System.out.print("Generated array is:      ");
        for (int i = 0; i < 20; i++) {
            array[i] = (int) (Math.random() * 100);
            System.out.print(array[i] + " ");
        }

        System.out.println();
        sort(array);

        System.out.print("Reverse sorted array is: ");
        for (int x = 0; x < array.length; x++) {
            int y = array.length - x - 1;
            System.out.print(array[y] + " ");
        }
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int d = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = d;
                }
            }
        }
    }
}
