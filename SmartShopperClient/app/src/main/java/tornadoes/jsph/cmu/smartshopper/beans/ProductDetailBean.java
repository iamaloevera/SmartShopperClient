package tornadoes.jsph.cmu.smartshopper.beans;

import tornadoes.jsph.cmu.smartshopper.entities.IProductSearch;
import tornadoes.jsph.cmu.smartshopper.entities.ProductSearchResult;

/**
 * Created by pritam on 12/7/15.
 */
public class ProductDetailBean {

    String barcode;

    IProductSearch ips;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getProductDetail(){

        ips=new ProductSearchResult();

        return ips.getProductResult(this);
    }
}
