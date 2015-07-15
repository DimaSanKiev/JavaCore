package _bionic_university._2_bank;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class IncomeInterfaceDealsTest {

    @Test
    public void getIncomeSumTest() {
        IncomeInterfaceDeals storage = new IncomeInterfaceDeals();
        ArrayList<IncomeInterface> list;
        list = storage.initList();
        double sum = storage.getIncomeSum(list);
        assertEquals(65164.23, sum, 0.005);
    }

    @Test
    public void getPrincipalSumTest() {
        IncomeInterfaceDeals storage = new IncomeInterfaceDeals();
        ArrayList<IncomeInterface> list;
        list = storage.initList();
        double sum = storage.getPrincipalSum(list);
        assertEquals(1439000.0, sum);
    }

    @Test
    public void listSizeTest() {
        IncomeInterfaceDeals storage = new IncomeInterfaceDeals();
        ArrayList<IncomeInterface> list;
        list = storage.initList();
        assertEquals(6, list.size());

    }


}