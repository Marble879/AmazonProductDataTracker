package scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
TODO: does each item page have same html?
TODO: Do we need to consider currency - if so, then that could potentially be an attribute in the scraper?
 */

public class Scraper {

    Document doc;
    String title;
    Elements codes;
    Elements content;

    public Scraper(String websiteUrl, Elements content, Elements code){

        try {
            doc = Jsoup.connect(websiteUrl).get();
        } catch(Exception e){
            e.printStackTrace();
        }

        // TODO pass content and codes as parameters!
        this.content = content;
        this.codes = code;
        this.title = doc.title();
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Elements getCodes(){
        return this.codes;
    }

}

