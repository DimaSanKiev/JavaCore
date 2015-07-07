package _bionic_university._3_collections;

import junit.framework.TestCase;
import org.junit.Test;

public class DepositListTest extends TestCase {
    @Test
    public void test1() {
        DepositList list = new DepositList();
        list.init();
        double sum = list.getPrincipal();
        assertEquals(73000.0, sum, 0.005);
    }

    @Test
    public void test2() {
        DepositList list = new DepositList();
        list.init();
        list.remove();
        double sum = list.getPrincipal();
        assertEquals(65000.0, sum, 0.005);
    }

}