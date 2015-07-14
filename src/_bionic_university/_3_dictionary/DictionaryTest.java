package _bionic_university._3_dictionary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DictionaryTest {

    @Test
    public void testTranslate() {
        Dictionary dict = new Dictionary();
        dict.init();
        assertEquals(dict.getTransl("Save"), "Запоминть");
    }

    @Test
    public void testNull() {
        Dictionary dict = new Dictionary();
        dict.init();
        assertEquals(dict.getTransl("Ok"), "Ok");
    }

}
