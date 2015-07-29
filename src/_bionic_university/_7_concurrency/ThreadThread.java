package _bionic_university._7_concurrency;

public class ThreadThread extends Thread {
    public void run() {

        for (int i = 0; i < 6; i++) {
            System.out.println("Thread " + Thread.currentThread().getId() + "    iteration " + i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ie) {
                return;
            }
        }
        System.out.println("Thread " + Thread.currentThread().getId() + " has been finished");
    }

}
