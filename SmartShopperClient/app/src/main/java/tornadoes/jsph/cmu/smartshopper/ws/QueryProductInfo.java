package tornadoes.jsph.cmu.smartshopper.ws;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import tornadoes.jsph.cmu.smartshopper.utils.StringUtils;

public class QueryProductInfo extends CreateWSConnection{
    private String barcode;

    public QueryProductInfo(String barcode){
        super() ;
        this.barcode = barcode;
    }

    public String sendProductBarcode()  {



        String urlToRead=getBaseUrl()+"/price_compare";
        StringBuilder result = new StringBuilder();

        String productDetailString="";
        try {

            String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()

            String query = String.format("barcode="+URLEncoder.encode(barcode, charset));

            URL url = new URL(urlToRead+"?"+query);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");


            productDetailString= StringUtils.getStringFromInputStream(conn.getInputStream());

        }catch (Exception e){
            e.printStackTrace();
        }

        return productDetailString;

    }

}
