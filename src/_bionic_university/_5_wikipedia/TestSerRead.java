package _bionic_university._5_wikipedia;

import java.util.HashSet;
import java.util.Set;

public class TestSerRead {
    public static void main(String[] args) {
        WikiLinksCollector test = new WikiLinksCollector();
        test.read("wikilinks.dat");
        Set<WikiLink> list = new HashSet<>();
        list.addAll(test.getList());
        list.forEach(System.out::println);
    }
}
