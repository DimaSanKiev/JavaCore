package _bionic_university._2_bank;

public class TestMain {
    public static void main(String[] args) throws InterruptedException {
        ThreadTest r = new ThreadTest();
        DepoList list = new DepoList();
        list.init();
        r.setList(list);
        r.setIndex(2);
        System.out.println(r.getSum());

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(r.getSum());
    }
}
