package _bionic_university._7_concurrency._2_fibonacci;

public class ThreadCustomer implements Runnable {
    Fibonacci fibonacci = null;

    public void setFibonacci(Fibonacci fibonacci) {
        this.fibonacci = fibonacci;
    }

    public void run() {
        int length = fibonacci.getLength();
        int[] serial = fibonacci.getNumbers();
        if (serial == null)
            return;
        for (int i = 0; i < length; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.print(serial[i] + "  ");
        }
    }
}

