package procedural_java;

/*
This program outputs current date in "dd.MM.yyyy" format.
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateOutput {
    public static void main(String[] args) {
        Date currentDate;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        currentDate = new Date();
        System.out.println("Today is: " + sdf.format(currentDate));
    }
}
