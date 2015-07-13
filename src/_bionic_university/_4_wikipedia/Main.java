package _bionic_university._4_wikipedia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Article hibernate = new Article();
        hibernate.setName("Hibernate");
        hibernate.setUrl("https://en.wikipedia.org/wiki/Hibernate_(Java)");
        hibernate.setDescription("Hibernate ORM is an object-relational mapping framework for the Java language, providing a framework for mapping an object-oriented domain model to a traditional relational database.");
        List<Link> links = addLinks();
        Collections.sort(links, new LinkComparator());
        System.out.println(hibernate);
        links.forEach(System.out::println);
    }

    public static List<Link> addLinks() {
        List<Link> links = new ArrayList<>();

        Link orm = new Link();
        orm.setName("ORM");
        orm.setUrl("https://en.wikipedia.org/wiki/Object-relational_mapping");
        orm.setDescription("Object-relational mapping (ORM) is a technique of accessing a relational database from Java.");
        orm.setImportance(2);
        orm.setProgress(20);

        Link sql = new Link();
        sql.setName("SQL");
        sql.setUrl("https://en.wikipedia.org/wiki/SQL");
        sql.setDescription("SQL is a standard language for accessing databases.");
        sql.setImportance(1);
        sql.setProgress(50);

        Link jpa = new Link();
        jpa.setName("JPA");
        jpa.setUrl("https://en.wikipedia.org/wiki/Java_Persistence_API");
        jpa.setDescription("The Java Persistence API provides a POJO persistence model for object-relational mapping.");
        jpa.setImportance(2);
        jpa.setProgress(10);

        Link servlet = new Link();
        servlet.setName("Servlet API");
        servlet.setUrl("https://en.wikipedia.org/wiki/Java_servlet");
        servlet.setDescription("A Java servlet is a Java programming language program that extends the capabilities of a server. ");
        servlet.setImportance(1);
        servlet.setProgress(50);

        links.add(orm);
        links.add(sql);
        links.add(jpa);
        links.add(servlet);

        return links;
    }
}
