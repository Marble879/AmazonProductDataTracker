package scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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

    //TODO once connect main menu to scraper, then output messages etc should be made in menu. This class should just return values scraped from the web.
    public String getProductPrice(){
        Elements elemPrice = doc.select("#priceblock_ourprice");
        String discount;
        String priceBeforeDiscount;
        String stringPrice = elemPrice.html().replace("&nbsp;", "");
        if(isDiscount()){
            discount = receiveDiscount();
            priceBeforeDiscount = receiveBeforeDiscountPrice();
            stringPrice = stringPrice + IoUtils.EOL + "Discount is: " + discount + IoUtils.EOL + "Price before discount is: " + priceBeforeDiscount + IoUtils.EOL;
        }
        return stringPrice;
    }

    public boolean isDiscount(){ // checks if there is a discount.
        Elements elemDiscount = this.doc.select("#regularprice_savings");
        return elemDiscount.size() > 0;
    }

    public String receiveDiscount(){
        Elements elemDiscount = this.doc.select("td.a-span12.a-color-price.a-size-base.priceBlockSavingsString");
        String stringPrice = elemDiscount.html().replace("&nbsp;", "");
        return stringPrice;
    }

    public String receiveBeforeDiscountPrice(){
        Elements elemBeforePrice = this.doc.select("span.priceBlockStrikePriceString.a-text-strike");
        String stringBeforePrice = elemBeforePrice.html().replace("&nbsp;", "");
        return stringBeforePrice;
    }

}

