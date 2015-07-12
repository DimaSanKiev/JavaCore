package _bionic_university._4_wikipedia;

public class Main {
    public static void main(String[] args) {
        Article hibernate = new Article();
        hibernate.setName("Hibernate");
        hibernate.setUrl("https://en.wikipedia.org/wiki/Hibernate_(Java)");
        hibernate.setDescription("Hibernate ORM (Hibernate in short) is an object-relational mapping framework for the Java language, providing a framework for mapping an object-oriented domain model to a traditional relational database.");

        Link mapping = new Link();
        mapping.setName("Mapping");
        mapping.setUrl("https://en.wikipedia.org/wiki/Hibernate_(Java)#Mapping");
        mapping.setDescription("Mapping Java classes to database tables is accomplished through the configuration of an XML file or by using Java Annotations.");
        Link.Importance high = Link.Importance.HIGH;
    }
}
