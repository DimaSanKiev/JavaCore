package euler_project;
/*
Numbers divisible by 3 and 5.
All natural numbers less than 10 and divisible by 3 and 5, are 3, 5, 6 and 9. Sum of that numbers is 23.
Find sum of all numbers less than 1000, that are divisible by 3 and 5.
 */

public class Task01 {
    public static void main(String[] args) {
        int limit = 1000;
        int sum = 0;
        long tic = System.nanoTime();
        for (int i = 1; i < limit; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                System.out.print(i + " ");
                sum += i;
            }
        }
        System.out.println();
        System.out.println("Sum is: " + sum);
        long tac = System.nanoTime();
        System.out.println("Time: " + (tac - tic) + " ns" + " ~ " + (tac - tic) / 1000000 + " ms");
    }

}
