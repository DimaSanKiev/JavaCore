package _bionic_university._1_easter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EasterCalculator {
    public static void main(String[] args) {
        EasterCalculator obj = new EasterCalculator();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyy");

        for (int year = 2016; year < 2026; year++) {
            System.out.println("Easter  in " + year + " will be on " + obj.getEasterDate(year).format(formatter));
            System.out.println("Trinity in " + year + " will be on " + obj.getEasterDate(year).plusWeeks(7).format(formatter));
            System.out.println();
        }
    }

    public LocalDate getEasterDate(int year) {
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int k = year / 100;
        int p = (13 + 8 * k) / 25;
        int q = k / 4;
        int M = (15 - p + k - q) % 30;
        int N = (4 + k - q) % 7;
        int d = (19 * a + M) % 30;
        int e = (2 * b + 4 * c + 6 * d + N) % 7;

        if (d == 29 && e == 6) {
            return LocalDate.of(year, 3, 22).plusDays(d + e).minusDays(7);
        } else
            return LocalDate.of(year, 3, 22).plusDays(d + e);
    }
}
