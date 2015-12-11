package tornadoes.jsph.cmu.smartshopper.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Map;
import java.util.Set;

import tornadoes.jsph.cmu.smartshopper.model.ProductResults;

public class DeserializeResult {

    ProductResults[] details;

    public   ProductResults[] parseJson(String jsonString) {


        JsonParser parser = new JsonParser();
        JsonObject regObj = parser.parse(jsonString).getAsJsonObject();

        JsonElement res_count = regObj.get("total_results_count");


        String total_count = res_count.getAsString();
        int total_results = Integer.parseInt(total_count);

        JsonArray resultArray = regObj.get("results").getAsJsonArray();


        details = new ProductResults[total_results];


        for (int i = 0; i < details.length; i++) {
            details[i] = new ProductResults();


            //Populate Site Detail Object

            JsonObject currentObject = resultArray.get(i).getAsJsonObject();

            System.out.println(currentObject);

            String image = currentObject.get("images").getAsJsonArray().get(0).getAsString();
            String brand = currentObject.get("brand").getAsString();
            Set<Map.Entry<String, JsonElement>> features = currentObject.get("features").getAsJsonObject().entrySet();

            String name="";
            if(currentObject.get("name")!=null){
                name=currentObject.get("name").getAsString();
            }
            String manufacturer="";
            if(currentObject.get("manufacturer")!=null){
                manufacturer=currentObject.get("manufacturer").getAsString();
            }
            String price="";
            if(currentObject.get("price")!=null){
                price=currentObject.get("price").getAsString();
            }
            String price_currency="";
            if(currentObject.get("price_currency")!=null){
                price_currency=currentObject.get("price_currency").getAsString();
            }
            String upc="";
            if(currentObject.get("upc")!=null){
                upc=currentObject.get("upc").getAsString();
            }
            String category="";
            if(currentObject.get("category")!=null){
                category=currentObject.get("category").getAsString();
            }

            details[i].setImage(image);
            details[i].setBrand(brand);
            details[i].setFeatures(features);
            details[i].setName(name);
            details[i].setManufacturer(manufacturer);
            details[i].setPrice(price);
            details[i].setPrice_currency(price_currency);
            details[i].setUpc(upc);
            details[i].setCategory(category);

            System.out.println("****");
            System.out.println(currentObject.get("sitedetails").getAsJsonArray().get(0).getAsJsonObject().get("latestoffers").getAsJsonArray());
            System.out.println("****");

            JsonArray latest_offers = currentObject.get("sitedetails").getAsJsonArray().get(0).getAsJsonObject().get("latestoffers").getAsJsonArray();


            //      JsonArray latest_offers=currentObject.get("latestoffers").getAsJsonArray();

            details[i].setAvailableOffers(latest_offers);


            System.out.println(details[i].toString());



            // System.out.println(features.getAsJsonArray());


        }

        return details;

    }
}


