package _bionic_university._1_easter;

import junit.framework.TestCase;
import org.junit.Test;

import java.time.DayOfWeek;
        import java.time.LocalDate;

public class EasterCalculatorTest extends TestCase {

    @Test
    public void testSundayDecade() {
        EasterCalculator calc = new EasterCalculator();
        for (int year = 2016; year < 2026; year++) {
            LocalDate easterDate = calc.getEasterDate(2015);
            assertEquals(DayOfWeek.SUNDAY, easterDate.getDayOfWeek());
        }
    }

    @Test
    public void testSunday() {
        EasterCalculator calc = new EasterCalculator();
        LocalDate easterDate = calc.getEasterDate(2015);
        assertEquals(DayOfWeek.SUNDAY, easterDate.getDayOfWeek());
    }

    @Test
    public void test2015() {
        EasterCalculator calc = new EasterCalculator();
        LocalDate easterDate = calc.getEasterDate(2015);
        assertEquals(LocalDate.of(2015, 4, 5), easterDate);
    }
}