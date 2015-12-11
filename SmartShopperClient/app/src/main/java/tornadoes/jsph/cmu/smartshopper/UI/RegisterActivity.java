package tornadoes.jsph.cmu.smartshopper.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tornadoes.jsph.cmu.smartshopper.R;
import tornadoes.jsph.cmu.smartshopper.beans.RegisterUserBean;
import tornadoes.jsph.cmu.smartshopper.utils.StringUtils;

/**
 * Created by pritam on 11/15/15.
 */
public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Intent started");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


    }

    public void registerHandler(View view) {

        EditText unText = (EditText) findViewById(R.id.register_username);
        EditText emailText = (EditText) findViewById(R.id.register_email);
        EditText passwordText=(EditText) findViewById(R.id.register_password);
        EditText confirmPasswordText=(EditText) findViewById(R.id.register_password);
       String userName=unText.getText().toString();
       String  password=passwordText.getText().toString();
       String email= emailText.getText().toString();
       String confirmPassword=confirmPasswordText.getText().toString();

        Log.i("Smartshopper:", userName);
        Log.i("Smartshopper:", password);
        Log.i("Smartshopper:", email);
        Log.i("Smartshopper:", confirmPassword);
        if ((userName.isEmpty()) | (password.isEmpty()) |
                (email.isEmpty()) | (confirmPassword.isEmpty())  |
                (!password.equals(confirmPassword)) | (!isEmailValid(email))) {
            Intent intent = new Intent(getBaseContext(), ErrorUI.class);
            intent.putExtra("Error_String", "Wrong input for New User Registration");
            startActivity(intent);
        }
        else {

            System.out.println("Trying to create bean");

            RegisterUserBean rub=new RegisterUserBean(userName,password,email);
          //  System.out.println(rub.getRegisterResponse());

            String regRes=rub.getRegisterResponse();

            Boolean success=false;
            String status="";
            try {
                System.out.println(regRes);


                JsonParser parser = new JsonParser();
                JsonObject regObj = parser.parse(regRes).getAsJsonObject();




                 status=regObj.get("success").toString();

                if(StringUtils.stringToBoolean(status)){
                    Intent intent = new Intent(getBaseContext(), HomeActivity.class);
                    startActivity(intent);
                }else{

                    Intent intent = new Intent(getBaseContext(), ErrorUI.class);
                    intent.putExtra("Error_String", regObj.get("error").toString());
                    startActivity(intent);

                }



            }catch (Exception e){
                System.out.println("Exception in json");
            }
            //System.out.println(regObj.get("success"));







        }
    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
}
