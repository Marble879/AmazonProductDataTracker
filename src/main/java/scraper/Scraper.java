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

    public String getSuggestedDeliveryTime(){
        Elements elemDeliveryTime = this.doc.select("#mir-layout-DELIVERY_BLOCK-slot-DELIVERY_MESSAGE").select("b");
        String stringElemDeliveryTime = elemDeliveryTime.html();
        return "Estimated delivery time is: " + stringElemDeliveryTime;
    }


    //TODO once connect main menu to scraper, then output messages etc should be made in menu. This class should just return values scraped from the web.
    public String getProductPrice(){
        Elements elemPrice = doc.select("#priceblock_ourprice");
        String stringPrice = elemPrice.html().replace("&nbsp;", "");
        String discountInfo = getDiscountInfo();
        stringPrice = stringPrice + IoUtils.EOL + discountInfo;
        return stringPrice;
    }

    private String getDiscountInfo(){
        String returnString = "";
        String discount;
        String priceBeforeDiscount;
        if(isDiscount()) {
            discount = receiveDiscount();
            priceBeforeDiscount = receiveBeforeDiscountPrice();
            returnString = returnString + "Discount is: " + discount + IoUtils.EOL + "Price before discount is: " + priceBeforeDiscount + IoUtils.EOL;
        }
        return returnString;
    }

    private boolean isDiscount(){ // checks if there is a discount.
        Elements elemDiscount = this.doc.select("#regularprice_savings");
        return elemDiscount.size() > 0;
    }

    private String receiveDiscount(){
        Elements elemDiscount = this.doc.select("td.a-span12.a-color-price.a-size-base.priceBlockSavingsString");
        String stringPrice = elemDiscount.html().replace("&nbsp;", "");
        return stringPrice;
    }

    private String receiveBeforeDiscountPrice(){
        Elements elemBeforePrice = this.doc.select("span.priceBlockStrikePriceString.a-text-strike");
        String stringBeforePrice = elemBeforePrice.html().replace("&nbsp;", "");
        return stringBeforePrice;
    }

}

