package tornadoes.jsph.cmu.smartshopper.ws;

import java.util.ArrayList;

public class CreateWSConnection {

    String baseUrl;
    public CreateWSConnection(){
        baseUrl="http://10.0.23.4:8080";
    }

    public String getBaseUrl(){
        return baseUrl;
    }

    public String buildQueryString(ArrayList<String> parameters){

        return "";
    }

}
