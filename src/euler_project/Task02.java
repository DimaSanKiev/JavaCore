package euler_project;
/*
Even Fibonacci numbers.
Every next element of Fibonacci series is the sum of two previous. From 1 and 2, the first 10 elements are:
1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
Find the sum of all even elements of Fibonacci series, that are less than 4 millions.
*/

public class Task02 {
    public static void main(String[] args) {
        int result = 0;
        int maxNumber = 4_000_000;
        int next = 1;
        int last = 1;

        while (next < maxNumber) {
            next = next + last;
            last = next - last;

            if (next % 2 == 0) {
                result += next;
            }
        }
        System.out.println(result);
    }
}
