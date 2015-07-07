package _bionic_university._3_collections;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DictionaryTest {

    @Test
    public void test1() {
        Dictionary dict = new Dictionary();
        dict.init();
        assertEquals(dict.getTransl("Save"), "Запоминть");
    }

    @Test
    public void test2() {
        Dictionary dict = new Dictionary();
        dict.init();
        assertEquals(dict.getTransl("Ok"), "Ok");
    }

}
