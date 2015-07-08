package _bionic_university._3_arraylist_vs_linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ArrayListVsLinkedList {

    private static List<Integer> arrayList = new ArrayList<>();
    private static List<Integer> linkedList = new LinkedList<>();


    public static void main(String[] args) {
        ArrayListVsLinkedList test = new ArrayListVsLinkedList();
        test.init(10000);
        System.out.println(" Amount      ArrayList, ms      LinkedList, ms       Ratio");
        for (int i = 100; i <= 100000; i = i * 10) {
            int amount = (int) (i + Math.sqrt(i));
            double timeAL = test.addToMiddle(arrayList, i);
            double timeLL = test.addToMiddle(linkedList, i);
            double ratio = timeAL / timeLL;
            System.out.format("  %1$4d  %2$10d            %3$10d          ~%4$f %n", amount, (int)timeAL, (int)timeLL, ratio);
        }
    }

    public void init(int capacity) {
        for (int i = 0; i < capacity; i++) {
            arrayList.add(generateRandom());
            linkedList.add(generateRandom());
        }
    }

    public long addToMiddle(List<Integer> list, int amount) {
        long tic = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            list.add(list.size() / 2, generateRandom());
        }
        long tac = System.nanoTime();
        return (tac - tic) / 1_000_000;
    }

    public int generateRandom() {
        Random random = new Random();
        return random.nextInt(1000) + 1;
    }

}
