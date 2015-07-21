package _bionic_university._5_wikipedia;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScriptTranslatorXml {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(ClassLoader.getSystemResourceAsStream("files/wikilinks_script.xml"));

//        WikiLinksCollector collector = new WikiLinksCollector();
        List<WikiLink> list = new ArrayList<>();

        NodeList nodeList = document.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof WikiLink) {
                WikiLink wikiLink = new WikiLink();
                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);

                    if (cNode instanceof WikiLink) {
                        String content = cNode.getLastChild().getTextContent().trim();
                        switch (cNode.getNodeName()) {
                            case "name":
                                wikiLink.setName(content);
                                break;
                            case "url":
                                wikiLink.setUrl(content);
                                break;
                            case "linkProc":
                                wikiLink.setLinkProc(WikiLink.Status.valueOf(content));
                                break;
                            case "studyProc":
                                wikiLink.setStudyProc(WikiLink.Status.valueOf(content));
                                break;
                            case "priority":
                                wikiLink.setPriority(Integer.valueOf(content));
                                break;
                        }
                    }
                }
//                collector.addLink(wikiLink);
                list.add(wikiLink);
            }
        }

        list.forEach(System.out::println);
    }
}
