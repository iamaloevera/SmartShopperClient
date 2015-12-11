package tornadoes.jsph.cmu.smartshopper.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.Map;
import java.util.Set;

public class ProductResults {

    String brand;
    String image;
    Set<Map.Entry<String, JsonElement>> features;
    String name; //Name
    String manufacturer;
    String price;
    String price_currency;
    String upc;
    String category;
    ProductLatestOffers[] availableOffers; //Offers

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Map.Entry<String, JsonElement>> getFeatures() {
        return features;
    }

    public void setFeatures(Set<Map.Entry<String, JsonElement>> features) {
        this.features = features;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice_currency() {
        return price_currency;
    }

    public void setPrice_currency(String price_currency) {
        this.price_currency = price_currency;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ProductLatestOffers[] getAvailableOffers() {
        return availableOffers;
    }

    public ProductLatestOffers getAvailableOffers(int index) {

        return availableOffers[index];
    }

    public void setAvailableOffers(JsonArray ao) {

        this.availableOffers=new ProductLatestOffers[ao.size()];

        for(int i=0;i<ao.size();i++){

            availableOffers[i]=new ProductLatestOffers();
            availableOffers[i].setSeller(ao.get(i).getAsJsonObject().get("seller").getAsString());
            availableOffers[i].setPrice(ao.get(i).getAsJsonObject().get("price").getAsString());

        }
      //  this.availableOffers = availableOffers;
    }

    public String toString(){

        String ret= "Brand Name: "+brand+" Brand Features :"+features.toString()+"\n" +
                "Price "+price+" "+price_currency;

        for(int i=0;i<availableOffers.length;i++){
            ret+="\n"+availableOffers[i].toString();
        }
        return ret;
    }
}
