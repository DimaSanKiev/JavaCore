package _bionic_university._2_bank;

import java.time.LocalDate;

public class TestIncomeSum {
	public static void main(String[] args) {
		IncomeInterface[] deals = new IncomeInterface[6];
		LocalDate dt = LocalDate.of(2012, 9, 8);
		deals[0] = new Depo(dt, 20, 1000.0, 15.0);
		deals[1] = new Depo(dt, 180, 1000.0, 15.0);
		dt = LocalDate.of(2014, 9, 8);
		deals[2] = new Depo(dt, 20, 1000.0, 15.0);
		deals[3] = new Depo(dt, 180, 1000.0, 15.0);
		dt = LocalDate.of(2015, 10, 31);
		deals[4] = new TBill(1000.0, 975.0, 1000, dt);
		deals[5] = new TBill(1000.0, 920.0, 500, dt);
		double sum = 0.0;
		for (IncomeInterface d : deals) {
			sum += d.getIncome();
		}
		System.out.format("Total income = %1$8.2f", sum);
	}

}
