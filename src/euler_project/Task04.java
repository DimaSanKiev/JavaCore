package euler_project;
/*
Largest palindrome
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 õ 99.
Find the largest palindrome made from the product of two 3-digit numbers.
 */


public class Task04 {
    public static void main(String[] args) {

        System.out.println("---- METHOD 1 ----");
        long tic0 = System.nanoTime();
        PalindromeFinder0.findPalindrome(999 * 999); // Maximum possible value made from two 3-digit numbers.
        long tac0 = System.nanoTime();
        System.out.println("Time: " + (tac0 - tic0) + " ns" + " ~ " + (tac0 - tic0) / 1000000 + " ms");
        System.out.println();

        System.out.println("---- METHOD 2 ----");
        long tic1 = System.nanoTime();
        PalindromeFinder1.findPalindrome();
        long tac1 = System.nanoTime();
        System.out.println("Time: " + (tac1 - tic1) + " ns" + " ~ " + (tac1 - tic1) / 1000000 + " ms");
    }
}

// ---- METHOD 1 ----
class PalindromeFinder0 {
    /*
        Searching palindrome from the all possible values [998001...100001]. Not the best practice.
     */
    protected static void findPalindrome(int number) {
        for (int i = number; i >= 100001; i--) {
            if (isNumberPalindrome(i)) {
                for (int j = 999; j >= 100; j--) {
                    if (i % j == 0 & i / j <= 999 & i / j >= 100) {
                        System.out.println(i + " = " + j + " * " + i / j);
                        return;
                    }
                }
            }
        }
    }

    /*
        Method detects if a number is palindrome.
        It converts number to string, then divide it into two substrings, reverse one of them and checks if they are equal.
    */
    private static boolean isNumberPalindrome(int i) {
        String numberToString = String.valueOf(i);
        String leftPart = numberToString.substring(0, numberToString.length() / 2);
        String rightPart = numberToString.substring(numberToString.length() / 2, numberToString.length());
        String rightPartReversed = reverseString(rightPart);
        return leftPart.equals(rightPartReversed);
    }

    /*
        This method just reverses sting
     */
    private static String reverseString(String string) {
        StringBuilder sb = new StringBuilder(string);
        sb.reverse();
        return sb.toString();
    }

}

// ---- METHOD 2 ----
class PalindromeFinder1 {

    static int biggestPalindrome = 998899;

    protected static void findPalindrome() {
        while (biggestPalindrome >= 100001) {
            takeNextPalindrome(biggestPalindrome);
            for (int i = 999; i >= 100; i--) {
                if (biggestPalindrome % i == 0 & biggestPalindrome / i <= 999 & biggestPalindrome / i >= 100) {
                    System.out.println(biggestPalindrome + " = " + i + " * " + biggestPalindrome / i);
                    return;
                }
            }
        }
    }

    /*
        This method takes biggestPalindrome, converts it to string, takes it's half, parses to int and subtract 1.
        Then converts it back to string and concatenates with reversed string.
        Also this value will be a current biggest palindrome.
     */
    private static int takeNextPalindrome(int currentPalindrome) {
        String str = String.valueOf(currentPalindrome);
        String leftPart = str.substring(0, str.length() / 2);
        int partPalindrome = Integer.parseInt(leftPart);
        String palindromeLeftPart = String.valueOf(partPalindrome - 1);
        String palindromeRightPart = reverseString(palindromeLeftPart);
        int currentBiggestPalindrome = Integer.parseInt(palindromeLeftPart.concat(palindromeRightPart));
        biggestPalindrome = currentBiggestPalindrome;
        return currentBiggestPalindrome;
    }

    /*
        Method detects if a number is palindrome.
        It converts number to string, then divide it into two substrings, reverse one of them and checks if they are equal.
    */
    private static boolean isNumberPalindrome(int i) {
        String numberToString = String.valueOf(i);
        String leftPart = numberToString.substring(0, numberToString.length() / 2);
        String rightPart = numberToString.substring(numberToString.length() / 2, numberToString.length());
        String rightPartReversed = reverseString(rightPart);
        return leftPart.equals(rightPartReversed);
    }

    private static String reverseString(String string) {
        StringBuilder sb = new StringBuilder(string);
        return sb.reverse().toString();
    }

}

