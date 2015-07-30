package _bionic_university._7_concurrency._1_test_race;

public class ThreadRunnable implements Runnable {

    Thread thread = null;

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println("Thread " + Thread.currentThread().getId() + "    iteration " + i);
            try {
                Thread.sleep(500);
                if (i == 5)
                    thread.join();
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.println("Thread " + Thread.currentThread().getId() + " has been finished");
    }

}
