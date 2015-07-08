package _bionic_university._3_wikipedia;

import org.junit.Test;

import java.util.Map;

import static _bionic_university._3_wikipedia.WikiLinks.frequencyInit;
import static _bionic_university._3_wikipedia.WikiLinks.listInit;
import static org.junit.Assert.assertEquals;

public class WikiLinksTest {

    @Test
    public void testValues() {
        Map<String, Integer> map = frequencyInit(listInit());
        assertEquals(4, map.get("SQL"));
    }

}