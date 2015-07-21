package _bionic_university._5_wikipedia;

import java.io.*;

public class WikiLinksProcess {
    public static String log = "files/wikilinks.log";
    public static String script = "files/wikilinks_script.txt";

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream outF = new PrintStream(log);
        WikiLinksCollector collector = new WikiLinksCollector();
        collector.read();
        process(outF, collector);
        collector.save();
        outF.close();
        System.out.println("Execution completed.");
    }

    private static void process(PrintStream outF, WikiLinksCollector links) {
        BufferedReader inF = null;
        String txt;
        try {
            try {
                inF = new BufferedReader(new FileReader(script));
                while ((txt = inF.readLine()) != null) {
                    outF.println(txt);
                    String[] ops = txt.split("~");
                    switch (ops[0]) {
                        case "add":
                            int id = links.addLink(ops[1], ops[2]);
                            outF.println(" New link was added with id = " + id);
                            break;
                        case "report":
                            links.createHtml("files/" + ops[1]);
                            break;
                        default:
                            outF.println("   ERROR! Undefined operation.");
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                if (inF != null)
                    inF.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
