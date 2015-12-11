package tornadoes.jsph.cmu.smartshopper.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import tornadoes.jsph.cmu.smartshopper.R;
import tornadoes.jsph.cmu.smartshopper.entities.ProductSearchResult;

public class DisplayScannedProduct extends AppCompatActivity {
    private String product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_scanned_product);

        Intent i = getIntent();
        product = i.getStringExtra("Product Detail");

        TextView tv = (TextView) findViewById(R.id.ScanDisplay_text);
        tv.setText(product);

        Button b = (Button) findViewById(R.id.ScanDisplay_Continue);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), ResultActivity.class);
                i.putExtra("Product Detail",product);
                startActivity(i);
            }
        });
    }
}
