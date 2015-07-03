package _bionic_university._2_bank;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class DepoTest {

	@Test
	public void test1() {
		LocalDate dt = LocalDate.of(2012, 9, 8);
		Depo depo = new Depo(dt, 20, 1000.0, 15.0);
		double income = depo.getIncome();
		assertEquals(8.20, income, 0.005);
	}
	
	@Test
	public void test2() {
		LocalDate dt = LocalDate.of(2012, 9, 8);
		Depo depo = new Depo(dt, 180, 1000.0, 15.0);
		double income = depo.getIncome();
		assertEquals(73.84, income, 0.005);
	}
	
	@Test
	public void test3() {
		LocalDate dt = LocalDate.of(2014, 9, 8);
		Depo depo = new Depo(dt, 20, 1000.0, 15.0);
		double income = depo.getIncome();
		assertEquals(8.22, income, 0.005);
	}
	
	@Test
	public void test4() {
		LocalDate dt = LocalDate.of(2014, 9, 12);
		Depo depo = new Depo(dt, 180, 1000.0, 15.0);
		double income = depo.getIncome();
		assertEquals(73.97, income, 0.005);
	}

}
