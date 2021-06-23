package scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Scraper {

    Document doc;

    public Scraper(String websiteUrl){

        try {
            doc = Jsoup.connect(websiteUrl).get();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public String getProductPrice(){
        Elements elemPrice = doc.select("#priceblock_ourprice");
        String stringPrice = elemPrice.html().replace("&nbsp;", "");

        return stringPrice;
    }
}

