package _bionic_university._7_concurrency._2_fibonacci;

public class ThreadGenerator implements Runnable {
    Fibonacci fibonacci = null;

    public void setFibonacci(Fibonacci value) {
        fibonacci = value;
    }

    public void run() {
        fibonacci.generate();
    }

}
