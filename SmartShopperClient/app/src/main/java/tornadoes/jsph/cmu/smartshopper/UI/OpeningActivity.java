package tornadoes.jsph.cmu.smartshopper.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import tornadoes.jsph.cmu.smartshopper.R;

public class OpeningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        // Execute some code after 2 seconds have passed
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        }, 3000);
    }

}
