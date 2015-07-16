package _bionic_university._2_bank;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class Depo implements IncomeInterface, Comparable<Depo>, Serializable {
    private static final long serialVersionUID = 9165906448584120184L;

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

    @Override
    public double getPrincipal() {
        return sum;
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

    @Override
    public int compareTo(Depo depo) {
        if ((this.getIncome() - depo.getIncome()) > 0) return 1;
        if ((this.getIncome() - depo.getIncome()) < 0) return -1;
        return 0;
    }

    public static class DepoComparator implements Comparator<Depo> {
        public int compare(Depo depo1, Depo depo2){
            if (depo1.getSum() > depo2.getSum()) return 1;
            if (depo1.getSum() < depo2.getSum()) return -1;
            return 0;
        }
    }
}
