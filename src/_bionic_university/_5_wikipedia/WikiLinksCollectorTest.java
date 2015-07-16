package _bionic_university._5_wikipedia;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class WikiLinksCollectorTest {

    private static WikiLinksCollector collector;

    @BeforeClass
    public static void beforeTests() {
        collector = new WikiLinksCollector();
        collector.addLink("https://en.wikipedia.org/wiki/Object-relational_mapping", "ORM");
        collector.addLink("https://en.wikipedia.org/wiki/Object-relational_mapping", "ORM");
        collector.addLink("https://en.wikipedia.org/wiki/SQL", "SQL");
        collector.addLink("https://en.wikipedia.org/wiki/Java_Persistence_API", "JPA");
        collector.addLink("https://en.wikipedia.org/wiki/Java_Persistence_API", "JPA");
    }

    @Test
    public void testAddLink() throws Exception {
        WikiLink link = collector.getById(1);
        assertFalse(link == null);
        assertEquals(WikiLink.Status.NO, link.getLinkProc());
        assertEquals(WikiLink.Status.NO, link.getStudyProc());
        assertEquals(0, link.getPriority());
    }

    @Test
    public void testGetList() throws Exception {

    }

    @Test
    public void testGetById() throws Exception {

    }

    @Test
    public void testSetPriority() throws Exception {

    }

    @Test
    public void testSetLinkProc() throws Exception {

    }

    @Test
    public void testSetStudyProc() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }
}