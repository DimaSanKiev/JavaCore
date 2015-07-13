package _bionic_university._4_wikipedia;

import java.util.Comparator;

public class LinkComparator implements Comparator<Link> {

    // At first links compared by importance, then by progress and finally by alphabetical order
    @Override
    public int compare(Link link1, Link link2) {
        int result = link1.getImportance() - link2.getImportance();
        if (result != 0) return result;
        result = link1.getProgress() - link2.getProgress();
        if (result != 0) return result;
        return link1.compareTo(link2);
    }
}
