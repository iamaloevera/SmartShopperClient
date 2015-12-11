package tornadoes.jsph.cmu.smartshopper.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import tornadoes.jsph.cmu.smartshopper.R;
import tornadoes.jsph.cmu.smartshopper.beans.ProductDetailBean;
import tornadoes.jsph.cmu.smartshopper.com.google.zxing.integration.android.IntentIntegrator;
import tornadoes.jsph.cmu.smartshopper.com.google.zxing.integration.android.IntentResult;
import tornadoes.jsph.cmu.smartshopper.model.ProductResults;
import tornadoes.jsph.cmu.smartshopper.utils.DeserializeResult;

public class ScanActivity extends AppCompatActivity implements View.OnClickListener {
    private String scanContent;
    private String scanFormat;
    private Button scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        scan = (Button) findViewById(R.id.scan_button);
    }

    public void onClick(View v){
        if(v.getId()==R.id.scan_button){
            //scan
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        //retrieve scan result
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult.getContents() != null) {
            //we have a result
            scanContent = scanningResult.getContents();
            scanFormat = scanningResult.getFormatName();
            Log.i("SmartShopper", scanContent);
            Log.i("SmartShopper", scanFormat);

//            /*Get product data from server*/
//
//            ProductDetailBean pdb=new ProductDetailBean();
//            pdb.setBarcode(scanContent);
//
//            String detailString = pdb.getProductDetail();
//            DeserializeResult res = new DeserializeResult();
//            ProductResults[] scan_res= res.parseJson(detailString);
            Intent i = new Intent(getBaseContext(), ResultActivity.class);
            i.putExtra("Scan_Content", scanContent);
            startActivity(i);



        }
        else{
            Intent i = new Intent(getBaseContext(), ErrorUI.class);
            intent.putExtra("Error_String", "Product not scanned properly");
            startActivity(i);
        }
    }
}
