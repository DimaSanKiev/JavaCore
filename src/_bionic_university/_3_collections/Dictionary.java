package _bionic_university._3_collections;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    Map<String, String> dict = new HashMap<String, String>();

    public void init() {
        dict.put("Save", "���������");
        dict.put("Remove", "�������");
        dict.put("Cancel", "��������");
        dict.put("Create", "�������");
        dict.put("Ok", null);
    }

    public String getTransl(String engWord) {
        if (dict.get(engWord) == null) {
            return engWord;
        }
        return dict.get(engWord);

    }

}
