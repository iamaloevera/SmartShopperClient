package tornadoes.jsph.cmu.smartshopper.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by pritam on 12/7/15.
 */
public class StringUtils {


    // convert InputStream to String
    public static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }

    public static Boolean stringToBoolean(String s){
        if(s.toLowerCase().equals("true")){
            return true;
        }else{
            return false;
        }
    }

}
