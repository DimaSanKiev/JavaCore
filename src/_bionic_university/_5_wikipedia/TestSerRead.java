package _bionic_university._5_wikipedia;

public class TestSerRead {
    public static void main(String[] args) {
        WikiLinksCollector test = new WikiLinksCollector();
        test.read("links.txt");
        System.out.println(test.getList());
        System.out.println(test.getById(1));
    }
}
