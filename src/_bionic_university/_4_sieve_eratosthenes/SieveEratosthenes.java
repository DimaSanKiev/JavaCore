package _bionic_university._4_sieve_eratosthenes;

import java.util.HashMap;
import java.util.Map;

public class SieveEratosthenes {

    Map<Integer, Boolean> numbers = new HashMap<>();

    public static void main(String[] args) {
        SieveEratosthenes test = new SieveEratosthenes();
        test.init();
        test.findPrimes();
        test.showPrimes();
    }

    public void init() {
        for (int i = 0; i <= 30; i++) {
            numbers.put(i, true);
        }
        numbers.replace(0, false);
        numbers.replace(1, false);
    }

    public void findPrimes() {
        for (int i = 2; i * i < numbers.size(); i++) {
            if (numbers.get(i)) {
                int multiple = i * 2;
                while (multiple <= numbers.size()) {
                    numbers.replace(multiple, false);
                    multiple += i;
                }
            }
        }
    }

    public void showPrimes() {
        numbers.entrySet().stream().filter(Map.Entry::getValue).forEach(entry -> System.out.print(entry.getKey() + " "));
    }
}
