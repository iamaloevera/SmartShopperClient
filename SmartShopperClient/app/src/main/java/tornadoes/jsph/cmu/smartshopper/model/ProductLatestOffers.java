package tornadoes.jsph.cmu.smartshopper.model;

/**
 * Created by pritam on 12/9/15.
 */
public class ProductLatestOffers {

  String price;
  String seller;
  String name;
  String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String toString(){
        return "Seller : "+seller+" Price "+price;
    }
}
