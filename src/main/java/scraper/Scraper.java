package scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.IoUtils;

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
        String discount;
        String stringPrice = elemPrice.html().replace("&nbsp;", "");
        if(isDiscount()){
            discount = receiveDiscount();
            stringPrice = stringPrice + IoUtils.EOL + "Discount is: " + discount + IoUtils.EOL;
        }
        return stringPrice;
    }

    public boolean isDiscount(){ // checks if there is a discount.
        Elements elemDiscount = doc.select("#regularprice_savings");
        return elemDiscount.size() > 0;
    }

    public String receiveDiscount(){
        Elements elemDiscount = doc.select("#regularprice_savings");
        String stringPrice = elemDiscount.html().replace("&nbsp;", "");
        return stringPrice;
    }

    //TODO check if the returned price from getProductPrice is discounted. If it is, make sure to check this, and then output to user this is price on sale.
    //TODO if discounted is the returned one, return % of discount, return before price and mention that there is a discount!
}

