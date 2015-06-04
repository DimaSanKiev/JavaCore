package euler_project;

/*
The greatest prime divisor.
The prime divisors of 13195 are 5, 7, 13 and 29.
What is the greatest prime divisor of 600851475143?
*/
public class Task03 {
    //        static long number = 13195;
    static long number = 9;
//    static long number = 600851475143L;

    public static void main(String[] args) {
        long tic = System.nanoTime();
        // number1 is for decrease iterations with dividing number by founded prime
        long number1 = 0;
        for (long n = 3; n * n <= number; n += 2) {
            while (number % n == 0) {
                number1 = n;
                number = number / n;
            }
        }
        System.out.println((number == 1) ? number1 : number);
        long tac = System.nanoTime();
        System.out.println("Time: " + (tac - tic) + " ns" + " ~ " + (tac - tic) / 1000000 + " ms");
    }
}
