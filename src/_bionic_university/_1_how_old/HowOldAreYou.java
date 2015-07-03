package _bionic_university._1_how_old;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class HowOldAreYou {
    public static void main(String[] args) {
        LocalDate birthDate = LocalDate.of(1984, 6, 27);
        HowOldAreYou obj = new HowOldAreYou();

        System.out.println("Your age in days is  : " + obj.getAgeDays(birthDate));
        System.out.println("Your age in months is: " + obj.getAgeMonths(birthDate));
        System.out.println("You was born on      : " + obj.getBirthdayDay(birthDate));
    }

    public int getAgeDays(LocalDate birthDate) {
        return (int) birthDate.until(LocalDate.now(), ChronoUnit.DAYS);
    }

    public int getAgeMonths(LocalDate birthDate) {
        return (int) birthDate.until(LocalDate.now(), ChronoUnit.MONTHS);

    }

    public String getBirthdayDay(LocalDate birthDate) {
        return birthDate.getDayOfWeek().toString();
    }
}
