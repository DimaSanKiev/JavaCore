package _bionic_university._1_bank;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Depo implements IncomeInterface {
	private LocalDate startDate;
	private int dayLong;
	private double sum;
	private double interestRate;

	public Depo() {
	}

	public Depo(LocalDate startDate, int dayLong, double sum,
			double interestRate) {
		this.startDate = startDate;
		this.dayLong = dayLong;
		this.sum = sum;
		this.interestRate = interestRate;
	}

	private double calculateInterest(LocalDate start, LocalDate maturity) {
		int daysInYear = 365;
		if (start.isLeapYear()) {
			daysInYear = 366;
		}
		double dayCf = start.until(maturity, ChronoUnit.DAYS) + 1;
		double interest = sum * (interestRate / 100.0) * (dayCf / daysInYear);
		return interest;
	}

	public double getIncome() {
		double interest = 0.0;
		LocalDate maturity = startDate.plusDays(dayLong);
		int startYear = startDate.getYear();
		int maturityYear = maturity.getYear();
		startDate = startDate.plusDays(1);
		if (startYear == maturityYear) {
			interest = calculateInterest(startDate, maturity);
		} else {
			LocalDate endOfYear = LocalDate.of(startYear, 12, 31);
			interest = calculateInterest(startDate, endOfYear);
			LocalDate beginOfYear = endOfYear.plusDays(1);
			interest += calculateInterest(beginOfYear, maturity);
		}
		return interest;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public int getDayLong() {
		return dayLong;
	}

	public void setDayLong(int dayLong) {
		this.dayLong = dayLong;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

}
