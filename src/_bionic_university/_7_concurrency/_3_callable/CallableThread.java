package _bionic_university._7_concurrency._3_callable;


import java.util.concurrent.Callable;

public class CallableThread implements Callable<Integer> {
    private long n;
    Divider d = null;

    public CallableThread(long n) {
        this.n = n;
        d = new Divider();
    }
    public Integer call() throws InterruptedException{
        return d.getCountOfDividers(n);
    }
}