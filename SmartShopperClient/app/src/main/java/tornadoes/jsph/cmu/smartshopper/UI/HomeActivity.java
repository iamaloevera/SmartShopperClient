package tornadoes.jsph.cmu.smartshopper.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import tornadoes.jsph.cmu.smartshopper.R;

public class HomeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
/*        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/

    }


    public void scanHandler(View view) {

        Intent intent = new Intent(getBaseContext(), ScanActivity.class);

        startActivity(intent);
    }

    public void historyHandler(View view) {

        Intent intent = new Intent(getBaseContext(), HistoryActivity.class);

        startActivity(intent);



    }
}
