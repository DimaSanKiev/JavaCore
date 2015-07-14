package _bionic_university._4_sieve_eratosthenes;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SieveEratosthenesJava8 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int limit = 30;
        for (int i = 2; i < limit; i++) {
            list.add(i);
        }
        int i = 0;
        while (true) {
            int p = list.get(i);
            if (p * p > limit) break;
            list = (ArrayList<Integer>) list.stream().filter(n -> (n <= p) || (n % p > 0)).collect(Collectors.toList());
            i++;
        }
        list.forEach(System.out::println);
    }
}
