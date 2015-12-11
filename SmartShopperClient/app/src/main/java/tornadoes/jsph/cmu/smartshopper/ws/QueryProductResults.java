package tornadoes.jsph.cmu.smartshopper.ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import tornadoes.jsph.cmu.smartshopper.entities.ProductSearchResult;

public class QueryProductResults extends CreateWSConnection {

    private StringBuilder result = new StringBuilder();

    public boolean QuerySearchResult()  {

        String urlToRead=getBaseUrl()+"/queryProductResult";

        try {

            String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()

            //String query = String.format("barcode="+ URLEncoder.encode(barcode, charset));

            URL url = new URL(urlToRead);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");


            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            ProductSearchResult p = new ProductSearchResult(); /*Add data to this*/
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return true;

    }

}
