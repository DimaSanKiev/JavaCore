package _bionic_university._2_bank;

public class DepoRunnableTest {
    public static void main(String[] args) {
        DepoList list = new DepoList();
        list.init();
        DepoRunnable dr = new DepoRunnable(list);
        Thread t = new Thread(dr);
        t.start();
    }
}
