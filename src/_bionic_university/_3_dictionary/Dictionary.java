package _bionic_university._3_dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    Map<String, String> dict = new HashMap<String, String>();

    // Hardcode init
    public void init() {
        dict.put("Save", "Запоминть");
        dict.put("Remove", "Удалить");
        dict.put("Cancel", "Прервать");
        dict.put("Create", "Создать");
        dict.put("Ok", null);
    }

    // Init with dict.txt file
    public void read(String fileId){
        dict.clear();
        try(BufferedReader in = new BufferedReader(new FileReader(fileId));){
            String txt;
            while ((txt = in.readLine()) != null){
                txt = txt.replace("\uFEFF", "");
                String[] buf = txt.split("`");
                int len = buf.length;
                if (len > 0){
                    String key = buf[0];
                    String value = null;
                    if (len > 1){
                        value = buf[1];
                    }
                    dict.put(key, value);
                }
            }
        }
        catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public String getTransl(String engWord) {
        if (dict.get(engWord) == null) {
            return engWord;
        }
        return dict.get(engWord);

    }

}
