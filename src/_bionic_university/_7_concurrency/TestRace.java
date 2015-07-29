package _bionic_university._7_concurrency;

public class TestRace {

    public static void main(String[] args) {
        ThreadRunnable tr = new ThreadRunnable();
        Thread t1 = new Thread(tr);
        Thread t2 = new ThreadThread();
        tr.setThread(t2);
        t1.start();
        t2.start();
    }
}
