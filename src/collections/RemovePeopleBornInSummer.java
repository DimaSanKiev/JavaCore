package collections;

/*
This program removes all people who was born in summer
 */

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RemovePeopleBornInSummer {

    public static void main(String[] args) {
        HashMap<String, Date> birthDate = createMap();
        System.out.println("People list:" + birthDate);
        removeAllSummerPeople(birthDate);
        System.out.println("People who was born in summer: " + birthDate);
    }

    // create Map<String, Date> and put there 10 persons: "name" - "birth date"
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<>();
        map.put("Person0", new Date("JUNE 27 1984"));
        map.put("Person1", new Date("SEPTEMBER 9 1969"));
        map.put("Person2", new Date("JANUARY 13 1985"));
        map.put("Person3", new Date("OCTOBER 10 1985"));
        map.put("Person4", new Date("AUGUST 12 1984"));
        map.put("Person5", new Date("JULY 12 1984"));
        map.put("Person6", new Date("JULY 31 1984"));
        map.put("Person7", new Date("MAY 30 1984"));
        map.put("Person8", new Date("SEPTEMBER 14 1977"));
        map.put("Person8", new Date("JULY 27 2012"));
        return map;
    }

    // this method removes all people who was born in summer (months 6, 7 and 8)
    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            int month = iterator.next().getValue().getMonth() + 1;
            if (6 <= month && month <= 8) {
                iterator.remove();
            }
        }
    }

}
