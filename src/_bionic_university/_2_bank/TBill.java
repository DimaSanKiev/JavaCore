package _bionic_university._2_bank;

import java.time.LocalDate;

public class TBill implements IncomeInterface {
	private double nominal;
	private double price;
	private int amount;
	private LocalDate maturity;

	public TBill() {
	}

	public TBill(double nominal, double price, int amount, LocalDate maturity) {
		super();
		this.nominal = nominal;
		this.price = price;
		this.amount = amount;
		this.maturity = maturity;
	}

	public double getIncome() {
		double income = (nominal - price) * amount;
		return income;
	}

	@Override
	public double getSum() {
		return price * amount;
	}

	public double getNominal() {
		return nominal;
	}

	public void setNominal(double nominal) {
		this.nominal = nominal;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDate getMaturity() {
		return maturity;
	}

	public void setMaturity(LocalDate maturity) {
		this.maturity = maturity;
	}

}
