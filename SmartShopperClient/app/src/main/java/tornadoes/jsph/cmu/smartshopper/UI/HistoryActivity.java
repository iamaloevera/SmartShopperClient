package tornadoes.jsph.cmu.smartshopper.UI;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import tornadoes.jsph.cmu.smartshopper.R;
import tornadoes.jsph.cmu.smartshopper.beans.HistoryData;
import tornadoes.jsph.cmu.smartshopper.entities.ProductSearchResult;
import tornadoes.jsph.cmu.smartshopper.entities.ViewHistoryData;
import tornadoes.jsph.cmu.smartshopper.ws.SearchHistory;

public class HistoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        SearchHistory s = new SearchHistory();
        s.sendSearchHistoryRequest();
        ViewHistoryData viewHistoryData = new ViewHistoryData();
        /*For Test*/
        /*HistoryData  obj = new HistoryData();
        obj.setPrice("100");
        obj.setProductName("Samsung Galaxy S6");
        obj.setShopName("Target");
        obj.setShopDescription("Milpitas");
        viewHistoryData.setHistoryData(obj, 0);
        viewHistoryData.setHistoryData(obj,1);
        viewHistoryData.setHistoryData(obj,2);
        viewHistoryData.setHistoryData(obj,3);
        viewHistoryData.setHistoryData(obj,4);
        viewHistoryData.setHistoryData(obj,5);
        viewHistoryData.setHistoryData(obj,6);
        viewHistoryData.setHistoryData(obj,7);
        viewHistoryData.setHistoryData(obj,8);
        viewHistoryData.setHistoryData(obj,9);*/
        /*For Test*/

        ScrollView scrollView = new ScrollView(this);
        LinearLayout lLayout = new LinearLayout(this);
        lLayout.setId(0);
        lLayout.setOrientation(LinearLayout.VERTICAL);
        lLayout.setBackgroundResource(R.drawable.bg1);
        /*Heading*/
        TextView textView1 = new TextView(this);
        textView1.setText("Consumer Search History");
        textView1.setBackgroundColor(Color.BLUE);
        textView1.setTextColor(Color.WHITE);
        textView1.setPaddingRelative(500,0,300,10);
        ViewGroup.LayoutParams paramsText1 = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                                        ViewGroup.LayoutParams.WRAP_CONTENT);
        lLayout.addView(textView1, paramsText1);

        for(int i = 0; i < viewHistoryData.getHistoryData().size(); i++) {
            LinearLayout child = new LinearLayout(this);
            child.setId(0);
            child.setOrientation(LinearLayout.VERTICAL);
            child.setPadding(0,10,0,10);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                                       ViewGroup.LayoutParams.WRAP_CONTENT);

            StringBuilder sb = new StringBuilder();
            sb.append((i+1)+": Product Name : "+viewHistoryData.getHistoryData(i).getProductName()+"\n");
            sb.append("Shop Name : "+viewHistoryData.getHistoryData(i).getShopName()+"\n");
            sb.append("Shop Description : " + viewHistoryData.getHistoryData(i).getShopDescription() + "\n");
            sb.append("Product Price : " + viewHistoryData.getHistoryData(i).getPrice() + "\n");
            TextView textView = new TextView(this);
            textView.setText(sb.toString());
            textView.setBackgroundColor(Color.WHITE);
            ViewGroup.LayoutParams paramsText = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                                            ViewGroup.LayoutParams.WRAP_CONTENT);
            child.addView(textView,paramsText);
            lLayout.addView(child,params);
        }
        scrollView.addView(lLayout);
        this.setContentView(scrollView);
    }
}
