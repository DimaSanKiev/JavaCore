package _bionic_university._5_wikipedia;

public class TestSerWrite {
    public static void main(String[] args) {
        WikiLinksCollector test = new WikiLinksCollector();
        test.addLink("https://en.wikipedia.org/wiki/Object-relational_mapping", "ORM");
        test.addLink("https://en.wikipedia.org/wiki/SQL", "SQL");
        test.addLink("https://en.wikipedia.org/wiki/Java_Persistence_API", "JPA");
        test.save();
        System.out.println("WikiLinks list has been saved");
    }
}
