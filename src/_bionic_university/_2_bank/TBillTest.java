package _bionic_university._2_bank;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TBillTest {

	@Test
	public void test() {
		LocalDate dt = LocalDate.of(2015, 10, 31);
		TBill bill = new TBill(1000.0, 975.0, 1000, dt);
		double income = bill.getIncome();
		assertEquals(25000.0, income, 0.005);
	}

}
