package _bionic_university._3_wikilinks;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestLinksCollect {

    private static LinksCollect collect;

    @BeforeClass
    public static void beforeTests() {
        collect = new LinksCollect();
        collect.addLink("https://en.wikipedia.org/wiki/Integer_factorization", "Integer factorization");
        collect.addLink("https://en.wikipedia.org/wiki/Integer_factorization", "Integer factorization");
        collect.addLink("https://en.wikipedia.org/wiki/Euclid%27s_lemma", "Euclid's lemma");
        collect.addLink("https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes", "Sieve of Eratosthenes");
        collect.addLink("https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes", "Sieve of Eratosthenes");
    }

    @Test
    public void test1AddLink() {
        Link l = collect.getById(1);
        assertFalse(l == null);
        assertEquals(Link.Status.NO, l.getLinksProc());
        assertEquals(Link.Status.NO, l.getStudyProc());
        assertEquals(0, l.getPriority());
    }

    @Test
    public void test2FindById() {
        Link l = collect.getById(1);
        assertEquals(Link.Status.NO, l.getLinksProc());
        assertEquals(Link.Status.NO, l.getStudyProc());
        assertEquals(0, l.getPriority());
    }

    @Test
    public void test3SetPrio() {
        collect.setPrio(2, 1);
        Link l = collect.getById(2);
        assertEquals(1, l.getPriority());
    }

    @Test
    public void test4SetLinksProc() {
        collect.setLinksProc(2, Link.Status.INPROGRESS);
        Link l = collect.getById(2);
        assertEquals(Link.Status.INPROGRESS, l.getLinksProc());
    }

    @Test
    public void test5SetStudyProc() {
        collect.setStudyProc(3, Link.Status.FINISHED);
        Link l = collect.getById(3);
        assertEquals(Link.Status.FINISHED, l.getStudyProc());
    }

    @Test
    public void test6Update() {
        Link l = collect.getById(3);
        l.setPriority(5);
        collect.update(l);
        l = collect.getById(3);
        assertEquals(5, l.getPriority());

    }
}
