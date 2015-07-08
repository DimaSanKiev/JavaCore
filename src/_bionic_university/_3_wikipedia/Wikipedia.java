package _bionic_university._3_wikipedia;

import java.util.*;

// https://en.wikipedia.org/wiki/Hibernate_(Java)
public class Wikipedia {

    public static void main(String[] args) {
        Wikipedia test = new Wikipedia();
        test.listInit();
//        for (List l : )
    }

    List<String> allLinks = listInit();

    // List for all links on the webpage
    public List<String> listInit() {
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
    public Map<String, Integer> init() {
        Map<String, Integer> links = new HashMap<>();

        return links;
    }

}
