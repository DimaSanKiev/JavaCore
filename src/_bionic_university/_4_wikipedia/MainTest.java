package _bionic_university._4_wikipedia;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MainTest {

    @Test
    public void testList1() {
        Article hibernate = new Article();
        List<Link> links = Main.addLinks();
        assertNotNull(links);
    }

    @Test
    public void testList2() {
        Article hibernate = new Article();
        List<Link> links = Main.addLinks();
        assertEquals(4, links.size());
    }

}