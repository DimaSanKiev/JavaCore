package _bionic_university._7_concurrency._2_fibonacci;

public class Fibonacci {
    private int[] numbers = null;
    private int length;

    public Fibonacci() {
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void generate() {
        if (length > 0) {
            numbers = new int[length];
            numbers[0] = 1;
        }
        if (length > 1) {
            numbers[1] = 1;
        }
        if (length > 2) {
            for (int i = 2; i < length; i++) {
                numbers[i] = numbers[i - 1] + numbers[i - 2];
            }
        }
    }

}
