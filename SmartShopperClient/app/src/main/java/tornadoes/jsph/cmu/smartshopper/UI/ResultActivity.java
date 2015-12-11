package tornadoes.jsph.cmu.smartshopper.UI;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.xml.transform.Result;

import tornadoes.jsph.cmu.smartshopper.R;
import tornadoes.jsph.cmu.smartshopper.beans.ProductDetailBean;
import tornadoes.jsph.cmu.smartshopper.entities.ProductSearchResult;
import tornadoes.jsph.cmu.smartshopper.model.ProductResults;
import tornadoes.jsph.cmu.smartshopper.utils.DeserializeResult;
import tornadoes.jsph.cmu.smartshopper.ws.QueryProductResults;

import static tornadoes.jsph.cmu.smartshopper.R.drawable.bg1;

public class ResultActivity extends AppCompatActivity {

    ProductResults[] scan_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int j = 0;
        System.out.println("Result Activity");
        String scanContent;
        super.onCreate(savedInstanceState);


        Intent intent = getIntent();
        scanContent = intent.getStringExtra("Scan_Content");

        /*Get product data from server*/

        ProductDetailBean pdb=new ProductDetailBean();
        pdb.setBarcode(scanContent);

        String detailString = pdb.getProductDetail();
        DeserializeResult res = new DeserializeResult();
        scan_res= res.parseJson(detailString);

        /*Display data*/

        ScrollView scrollView = new ScrollView(this);
        scrollView.setBackgroundResource(bg1);
        ViewGroup.LayoutParams paramsText5 = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        LinearLayout lLayout = new LinearLayout(this);
        lLayout.setId(0);
        lLayout.setOrientation(LinearLayout.VERTICAL);
        lLayout.setBackgroundResource(bg1);

        /*Product Name,Image and Features*/
        LinearLayout temp = new LinearLayout(this);
        temp.setId(0);
        temp.setOrientation(LinearLayout.VERTICAL);
        TextView textView1 = new TextView(this);
        textView1.setText(scan_res[0].getName());
        textView1.setBackgroundColor(Color.WHITE);
        textView1.setGravity(1);
        ViewGroup.LayoutParams paramsText1 = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                                                                        ViewGroup.LayoutParams.FILL_PARENT);
        URL url = null;
        try {
            url = new URL(scan_res[0].getImage());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Bitmap bmp = null;
        try {
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(bmp);
        temp.addView(textView1, paramsText1);
        temp.addView(imageView,paramsText1);
        lLayout.addView(temp);


        for(int i = 0; i < scan_res.length; i++) {
            for (int k = 0; k < scan_res[i].getAvailableOffers().length; k++) {
                LinearLayout child = new LinearLayout(this);
                child.setId(0);
                child.setOrientation(LinearLayout.HORIZONTAL);
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                TextView textView = new TextView(this);
                Log.i("SmartShopper",scan_res[i].getPrice());
                textView.setText(scan_res[i].getName() + "\n" + scan_res[i].getAvailableOffers(k).getSeller()+
                                "\n" + scan_res[i].getPrice());
                textView.setBackgroundColor(Color.WHITE);
                ViewGroup.LayoutParams paramsText = new ViewGroup.LayoutParams(700, ViewGroup.LayoutParams.WRAP_CONTENT);
                Button b = new Button(this);
                b.setText("Go to Map");
                b.setId(0);
                b.setTag(i+"$"+j);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // put code on click operation
                        //launches Google maps app with search for locationName around you
                        //also provides navigation functionality as available on Google maps app
                        String temp = v.getTag().toString();
                        StringTokenizer st = new StringTokenizer(temp,"$");
                        String locationName = scan_res[Integer.parseInt(st.nextToken())].getAvailableOffers(Integer.parseInt(st.nextToken())).getSeller();
                        Intent gMapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + locationName));
                        startActivity(gMapIntent);
                    }
                });
                child.addView(textView, paramsText);
                child.addView(b);
                lLayout.addView(child, params);
            }
        }
        scrollView.addView(lLayout);
        this.setContentView(scrollView,paramsText5);
    }
}

