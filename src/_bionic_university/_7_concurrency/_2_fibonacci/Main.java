package _bionic_university._7_concurrency._2_fibonacci;

public class Main {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.setLength(9);
        ThreadGenerator generator = new ThreadGenerator();
        generator.setFibonacci(fibonacci);
        ThreadCustomer customer = new ThreadCustomer();
        customer.setFibonacci(fibonacci);
        Thread t1 = new Thread(generator);
        Thread t2 = new Thread(customer);
        t1.start();
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        t2.start();
    }

}

