package _bionic_university._5_wikipedia;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

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
        assertNotNull(collector);
    }

    @Test
    public void testGetById() throws Exception {
        WikiLink link = collector.getById(1);
        assertEquals(WikiLink.Status.NO, link.getLinkProc());
        assertEquals(WikiLink.Status.NO, link.getStudyProc());
        assertEquals(0, link.getPriority());
    }

    @Test
    public void testSetPriority() throws Exception {
        collector.setPriority(2, 1);
        WikiLink link = collector.getById(2);
        assertEquals(1, link.getPriority());
    }

    @Test
    public void testSetLinkProc() throws Exception {
        collector.setLinkProc(2, WikiLink.Status.IN_PROGRESS);
        WikiLink link = collector.getById(2);
        assertEquals(WikiLink.Status.IN_PROGRESS, link.getLinkProc());
    }

    @Test
    public void testSetStudyProc() throws Exception {
        collector.setStudyProc(3, WikiLink.Status.FINISHED);
        WikiLink link = collector.getById(3);
        assertEquals(WikiLink.Status.FINISHED, link.getStudyProc());
    }

    @Test
    public void testUpdate() throws Exception {
        WikiLink link = collector.getById(3);
        link.setPriority(5);
        collector.update(link);
        link = collector.getById(3);
        assertEquals(5, link.getPriority());
    }
}