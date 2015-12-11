package tornadoes.jsph.cmu.smartshopper.ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ResetPassword extends CreateWSConnection {

    public boolean sendResetPasswordQuery(String userName)  {

        String urlToRead=getBaseUrl()+"/forgotPassword";
        StringBuilder result = new StringBuilder();

        try {

            String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()

            String query = String.format("username="+userName+ URLEncoder.encode(userName, charset));

            URL url = new URL(urlToRead+"?"+query);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");


            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
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
