package _bionic_university._5_wikipedia;

import java.io.*;
import java.util.ArrayList;

public class ScriptTranslatorTxt {
    private static WikiLinksCollector collector = new WikiLinksCollector();
    private static ArrayList<String> commands = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ScriptTranslatorTxt translator = new ScriptTranslatorTxt();
        translator.parseToList();
        commands.forEach(System.out::println);
        String add = ".add";
        if (commands.contains(add)) {
            int index = commands.indexOf(add);
            String url = commands.get(index + 1).substring(7, commands.get(index + 1).length() - 1);
            String name = commands.get(index + 2).substring(8, commands.get(index + 2).length() - 1);
            collector.addLink(url, name);
        }
        System.out.println(collector.getById(1));
    }

    public void parseToList() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("wikilinks_script.txt")));
        commands.clear();
        String next;
        do {
            next = reader.readLine();
            if (next.equals("WikiLink()")) continue;
            commands.add(next);
        } while (!next.equals(".end"));
        reader.close();

    }
}
