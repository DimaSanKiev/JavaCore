package _bionic_university.task01;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task01 {
    public static void main(String[] args) {
        Task01 task = new Task01();
        System.out.println(task.getNextWorkingDay(LocalDate.of(2015, 7, 4)));
    }

    public String getNextWorkingDay(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyy");
        if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
            return date.plusDays(3).format(formatter);
        } else if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
            return date.plusDays(2).format(formatter);
        } else
            return date.plusDays(1).format(formatter);
    }
}
