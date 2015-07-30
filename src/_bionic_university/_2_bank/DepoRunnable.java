package _bionic_university._2_bank;

public class DepoRunnable implements Runnable {
    final DepoList depoList;

    public DepoRunnable(DepoList list) {
        this.depoList = list;
    }

    @Override
    public void run() {
        double sum;
        for (int i = 0; i < depoList.size(); i++) {
            synchronized (depoList) {
                sum = depoList.getSum(i);
                System.out.println(depoList.getSum(i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                depoList.setSum(i, sum + 100.0);
            }

        }
    }

    private void add100() {
        for (int i = 0; i < depoList.size(); i++) {
            depoList.add100(i);
        }
    }
}
