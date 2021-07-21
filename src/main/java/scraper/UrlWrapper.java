package scraper;

public class UrlWrapper {

    String url;
    String productName;


    public UrlWrapper(String url, String productName){
        this.url = url;
        this.productName = productName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
