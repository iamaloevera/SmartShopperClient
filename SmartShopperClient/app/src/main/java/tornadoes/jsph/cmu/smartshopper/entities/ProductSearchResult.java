package tornadoes.jsph.cmu.smartshopper.entities;

import java.util.ArrayList;

import tornadoes.jsph.cmu.smartshopper.beans.ProductData;
import tornadoes.jsph.cmu.smartshopper.beans.ProductDetailBean;
import tornadoes.jsph.cmu.smartshopper.ws.QueryProductInfo;

public class ProductSearchResult implements IProductSearch{

    private final static int MAX_RECORD = 5;
    private static ArrayList<ProductData> result = new ArrayList<ProductData>(MAX_RECORD);

    public static ArrayList<ProductData> getResult() {
        return result;
    }

    public static void setResult(ArrayList<ProductData> result) {
        ProductSearchResult.result = result;
    }

    public static ProductData getResult(int shopNumber) {
        return result.get(shopNumber);
    }

    public static void setResult(ProductData result, int shopNumber) {
        ProductSearchResult.result.add(shopNumber,result);
    }

    public  String getProductResult(ProductDetailBean pd){

        String barcode=pd.getBarcode();
        QueryProductInfo qps=new QueryProductInfo(barcode);

        return qps.sendProductBarcode();

    }
}
