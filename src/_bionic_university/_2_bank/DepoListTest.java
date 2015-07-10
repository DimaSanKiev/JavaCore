package _bionic_university._2_bank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DepoListTest {

    @Test
    public void test1() {
        DepoList list = new DepoList();
        list.init();
        double sum = list.getPrincipal();
        assertEquals(73000.0, sum, 0.005);
    }

    @Test
    public void test2() {
        DepoList list = new DepoList();
        list.init();
        list.remove();
        double sum = list.getPrincipal();
        assertEquals(65000.0, sum, 0.005);
    }

}
