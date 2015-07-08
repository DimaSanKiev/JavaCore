package _bionic_university._3_wikipedia;

import java.util.*;

// https://en.wikipedia.org/wiki/Hibernate_(Java)
public class WikiLinks {

    public static void main(String[] args) {
        Map<String, Integer> map = frequencyInit(listInit());
//        System.out.println(map);
        ValuesComparator comparator = new ValuesComparator(map);
        Map<String, Integer> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(map);
        System.out.println("If you want to study Hibernate you should start with such the most important topics:");
        System.out.println(sortedMap);

    }

    // List for all links on the webpage
    static List<String> listInit() {
        List<String> links = new ArrayList<>();
        links.add("object-relational mapping");
        links.add("domain model");
        links.add("relational database");
        links.add("persistence");
        links.add("database tables");
        links.add("SQL");
        links.add("XML");
        links.add("Java Annotations");
        links.add("one-to-many");
        links.add("many-to-many");
        links.add("OOP");
        links.add("SQL");
        links.add("HQL");
        links.add("POJO");
        links.add("Java generics");
        links.add("SQL");
        links.add("XML");
        links.add("SQL");
        links.add("ORM");
        links.add("HQL");
        links.add("Servlet API");
        links.add("EJB");
        links.add("persistence");
        links.add("EJB");
        links.add("Java Annotations");
        links.add("Java Persistence API");
        links.add("ORM");
        links.add("ORM");
        links.add("org.hibernate.SessionFactory");
        links.add("org.hibernate.Session");
        links.add("ORM");
        links.add("Java Annotations");
        links.add("Java Persistence API");
        return links;
    }

    // Map for links on this page, key = link name, value = frequency
    static Map<String, Integer> frequencyInit(List<String> list) {
        Map<String, Integer> links = new HashMap<>();

        for (String listItem : list) {
            if (!links.containsKey(listItem)) {
                links.put(listItem, 1);
            } else {
                links.put(listItem, links.get(listItem) + 1);
            }
        }

        return links;
    }

}