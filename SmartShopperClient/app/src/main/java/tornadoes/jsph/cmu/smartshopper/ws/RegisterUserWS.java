package tornadoes.jsph.cmu.smartshopper.ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import tornadoes.jsph.cmu.smartshopper.utils.StringUtils;

/**
 * Created by pritam on 11/22/15.
 */
public class RegisterUserWS extends CreateWSConnection implements IUserRegisterWebService{

    public RegisterUserWS(){
        super();
    }

    public String userPersistToServer(String userName,String password,String email){

        System.out.println("Trying to register");
        System.out.println("****");

        String urlToRead=getBaseUrl()+"/register";
        StringBuilder result = new StringBuilder();



        String line="";
        try {

            String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()
            String param1 = "username";
            String param2 = "password";
            String param3="email";

            String query = String.format("username="+userName+"&password="+password+"&email="+email,
                    URLEncoder.encode(param1, charset),
                    URLEncoder.encode(param2, charset));

            URL url = new URL(urlToRead+"?"+query);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");


            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));


            line= StringUtils.getStringFromInputStream(conn.getInputStream());


        }catch (Exception e){
           System.out.println("Error in Registration Status");
        }

        return line;

    }

}
