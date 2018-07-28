import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class FirstTry {
    public static void main(String[] main) {
        final String URL = "http://www.fsticker.com/【free-list】line-sticker-8-set-stickers！july-24-2018/";
        try {
            Document doc = Jsoup.connect(URL).get();
            String title = doc.title();
            System.out.print(title);
            Elements countryNodes = doc.getElementsByAttributeValue("class", "country");
            for (Element e : countryNodes) {
                System.out.printf("Country: %s ; URL: %s\n",
                        e.text(),
                        e.nextElementSibling().text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
