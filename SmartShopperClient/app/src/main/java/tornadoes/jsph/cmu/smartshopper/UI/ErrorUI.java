package tornadoes.jsph.cmu.smartshopper.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import tornadoes.jsph.cmu.smartshopper.R;

public class ErrorUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_ui);

        Intent intent = getIntent();
        String errorMsg = intent.getStringExtra("Error_String");

        TextView tv = (TextView)findViewById(R.id.message_ErrorUI);
        tv.setText(errorMsg);
    }

}
