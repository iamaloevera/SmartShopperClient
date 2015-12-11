package tornadoes.jsph.cmu.smartshopper.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import tornadoes.jsph.cmu.smartshopper.R;
import tornadoes.jsph.cmu.smartshopper.beans.UserCredentialBean;
import tornadoes.jsph.cmu.smartshopper.entities.IAuthUser;
import tornadoes.jsph.cmu.smartshopper.utils.StringUtils;

public class MainActivity extends AppCompatActivity implements AppAuthenticator{

    String userName;
    String password;

    IAuthUser userAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //your codes here

        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loginHandler(View view) {

        EditText unText = (EditText) findViewById(R.id.username);
        EditText pText = (EditText) findViewById(R.id.password);
        userName=unText.getText().toString();
        password=pText.getText().toString();

        UserCredentialBean ucb=new UserCredentialBean();
        ucb.setUsername(userName);
        ucb.setPassword(password);

        String loginResponse=ucb.getUserLogin().toString();
        Log.i("SmartShopper", ucb.getUsername());
        Log.i("SmartShopper", ucb.getPassword());
        Log.i("SmartShopper", loginResponse);



        if(ucb.getUsername().isEmpty() | ucb.getPassword().isEmpty()) {
            /*Empty Credentials*/
            Intent intent = new Intent(getBaseContext(), ErrorUI.class);
            intent.putExtra("Error_String", "Please add proper input");
            startActivity(intent);
        }
        else{}


        System.out.println(loginResponse);

        try {
            JsonParser parser = new JsonParser();
            JsonObject loginObj = parser.parse(loginResponse).getAsJsonObject();


            String status = loginObj.get("success").toString();

            System.out.println(status);
            if(StringUtils.stringToBoolean(status)){
                Intent intent = new Intent(getBaseContext(), HomeActivity.class);
                startActivity(intent);
            }else{

                Intent intent = new Intent(getBaseContext(), ErrorUI.class);
                intent.putExtra("Error_String", "Wrong Credentials");
                startActivity(intent);
            }


        }catch (Exception e){
            System.out.println("JSON Exception");
        }

/*         if(ucb.getUserLogin()){
             *//*Correct Credential*//*
             Intent intent = new Intent(getBaseContext(), HomeActivity.class);
             startActivity(intent);
         }
         else {
             *//*Wrong Credentials*//*
             Intent intent = new Intent(getBaseContext(), ErrorUI.class);
             intent.putExtra("Error_String", "Wrong Credentials");
             startActivity(intent);
         }*/


    }

    public void registerHandler(View view){


        Intent intent = new Intent(getBaseContext(), RegisterActivity.class);

        startActivity(intent);




    }

}
