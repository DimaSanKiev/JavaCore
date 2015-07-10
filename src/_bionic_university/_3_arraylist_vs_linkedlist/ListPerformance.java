package _bionic_university._3_arraylist_vs_linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListPerformance {

    public static void main(String[] args) {
        test(10);
        test(100);
        test(1000);
        test(10000);
        test(100000);
        test(1000000);
    }

    static void test(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        long t1 = System.nanoTime();
        Array(list, n);
        long t2 = System.nanoTime();
        list.clear();
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        long t3 = System.nanoTime();
        Linked(list1, n);
        long t4 = System.nanoTime();
        double k = (t2 - t1);
        k /= (t4 - t3);
        System.out.println(String.format("n = %6d     k = %7.2f", n, k));
    }

    public static void Array(ArrayList<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(i / 2, i);
        }
    }

    public static void Linked(LinkedList<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(i / 2, i);
        }
    }
}
