package _bionic_university._7_concurrency._3_callable;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainTest {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> results = new ArrayList<>();
        long[] data = {103, 99883344213245776L, 10989067754000L, 3, 123456789098765L,
                3455566677L, 35, 81, 11133355588800098L, 77113344565l};

        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new CallableThread(data[i])));
        }
        try {
            while (true) {
                boolean isFinished = true;
                for (int i = 0; i < 10; i++) {
                    if (results.get(i).isDone()) {
                        System.out.format("i = %1$2d  n = %2$19d   dev = %3$3d \n", i, data[i], results.get(i).get());
                    } else isFinished = false;
                }
                System.out.println(" ");
                if (isFinished) break;
                Thread.sleep(500);
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        } finally {
            exec.shutdown();
        }
    }
}
