import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class LineStickerCatcher {
    public static void catchLineSticker(JTextArea textArea) {
        HashMap<String, String> pages = getURLs();
        for (String fileName : pages.keySet()) {
            String URL = pages.get(fileName);
            new File("FileOutput").mkdir();
            try (FileWriter output = new FileWriter(new File(String.format("FileOutput/%s.txt", fileName.substring(fileName.length() - 20))))) {
                Document docIn = Jsoup.connect(URL).get();
                String title = docIn.title();
                System.out.println(title);
                Elements countryNodes = docIn.getElementsByAttributeValue("class", "country");
                for (Element e : countryNodes) {
                    String outputString = String.format("Country: %s ; URL: %s\n",
                            e.text(),
                            e.nextElementSibling().text());
                    textArea.append(outputString);
                    System.out.printf(outputString);
                    output.write(outputString);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static HashMap<String, String> getURLs() {
        final String URL = "http://www.fsticker.com/tag/free-line-stickers/";
        HashMap<String, String> urls = new HashMap<>();
        try {
            Document doc = Jsoup.connect(URL).get();
            Elements elementsOfUrl = doc.getElementsByAttributeValue("rel", "bookmark");
            for (Element e : elementsOfUrl) {
                urls.put(e.text(), e.attr("href"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urls;
    }
}
