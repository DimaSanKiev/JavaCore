package _bionic_university._2_bank;

public class ThreadTest implements Runnable {
    DepoList list = null;
    int index = -1;

    public void setList(DepoList list) {
        this.list = list;
    }

    public void setIndex(int value) {
        index = value;
    }

    public double getSum() {
        return list.getSum(index);
    }

    public void run() {
        try {
            list.add100(index);
        } catch (Exception ex) {
            return;
        }
    }
}
