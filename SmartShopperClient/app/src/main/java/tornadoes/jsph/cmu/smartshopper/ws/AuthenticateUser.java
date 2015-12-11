package tornadoes.jsph.cmu.smartshopper.ws;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import tornadoes.jsph.cmu.smartshopper.utils.StringUtils;

public class AuthenticateUser extends CreateWSConnection implements IUserAuthWebService{

    public AuthenticateUser(){
        super();

    }

    public String checkUserCredentials(String userName,String password)  {

        String urlToRead=getBaseUrl()+"/login";
        StringBuilder result = new StringBuilder();


        String loginResponse="";

         try {

             String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()
             String param1 = "username";
             String param2 = "password";

             String query = String.format("username="+userName+"&password="+password,
                     URLEncoder.encode(param1, charset),
                     URLEncoder.encode(param2, charset));

             URL url = new URL(urlToRead+"?"+query);
             HttpURLConnection conn = (HttpURLConnection) url.openConnection();
             conn.setRequestMethod("GET");


              loginResponse= StringUtils.getStringFromInputStream(conn.getInputStream());
         }catch (Exception e){
                e.printStackTrace();
         }

        return loginResponse;

    }


}
