package _bionic_university._4_sieve_eratosthenes;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SieveEratosthenesTest {

    @Test
    public void test2isPrime() {
        SieveEratosthenes test = new SieveEratosthenes();
        test.init();
        test.findPrimes();
        assertEquals(true, test.numbers.get(2));
    }

    @Test
    public void testPrimesQuantity() {
        SieveEratosthenes test = new SieveEratosthenes();
        test.init();
        test.findPrimes();
        int primesQuantity = 0;
        for (Map.Entry<Integer, Boolean> entry : test.numbers.entrySet()) {
            if (entry.getValue()) {
                primesQuantity++;
            }
        }
        assertEquals(10, primesQuantity);
    }

}