package collections;

/*
This code test the performance of ArrayList and LinkedList on 4 operations:
Add, Get, Set, Remove.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedList {
    static int elementsQuantity = 10_000_000;

    public static void main(String[] args) throws Exception {

        List arrayList = new ArrayList();
        List linkedList = new LinkedList();

        // Add
        long tic0 = System.nanoTime();
        addElement(arrayList);
        long tac0 = System.nanoTime();
        long delta0 = (tac0 - tic0) / 1_000_000;
        System.out.println("ArrayList Insertion:  " + delta0 + " ms");

        long tic1 = System.nanoTime();
        addElement(linkedList);
        long tac1 = System.nanoTime();
        long delta1 = (tac1 - tic1) / 1_000_000;
        System.out.println("LinkedList Insertion: " + delta1 + " ms");

        // Get
        System.out.println();
        long tic2 = System.nanoTime();
        getElements(arrayList);
        long tac2 = System.nanoTime();
        long delta2 = (tac2 - tic2) / 1_000_000;
        System.out.println("ArrayList Get:  " + delta2 + " ms");

        long tic3 = System.nanoTime();
        getElements(linkedList);
        long tac3 = System.nanoTime();
        long delta3 = (tac3 - tic3) / 1_000_000;
        System.out.println("LinkedList Get: " + delta3 + " ms");

        // Set
        System.out.println();
        long tic4 = System.nanoTime();
        setElements(arrayList);
        long tac4 = System.nanoTime();
        long delta4 = (tac4 - tic4) / 1_000_000;
        System.out.println("ArrayList Set:  " + delta4 + " ms");

        long tic5 = System.nanoTime();
        setElements(linkedList);
        long tac5 = System.nanoTime();
        long delta5 = (tac5 - tic5) / 1_000_000;
        System.out.println("LinkedList Set: " + delta5 + " ms");

        // Remove
        System.out.println();
        long tic6 = System.nanoTime();
        removeElements(arrayList);
        long tac6 = System.nanoTime();
        long delta6 = (tac6 - tic6) / 1_000_000;
        System.out.println("ArrayList Remove:  " + delta6 + " ms");

        long tic7 = System.nanoTime();
        removeElements(linkedList);
        long tac7 = System.nanoTime();
        long delta7 = (tac7 - tic7) / 1_000_000;
        System.out.println("LinkedList Remove: " + delta7 + " ms");

    }

    public static void addElement(List list) {
        for (int i = 0; i < elementsQuantity; i++) {
            list.add(new Object());
        }
    }

    public static void getElements(List list) {
        for (int i = 0; i < elementsQuantity / 1000; i++) {
            list.get(i);
        }
    }

    public static void setElements(List list) {
        for (int i = 0; i < elementsQuantity / 1000; i++) {
            list.set(i, new Object());
        }
    }

    public static void removeElements(List list) {
        for (int i = 0; i < elementsQuantity / 10000; i++) {
            list.remove(0);
        }
    }
}
