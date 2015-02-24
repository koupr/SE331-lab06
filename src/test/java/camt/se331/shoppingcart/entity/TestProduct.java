package camt.se331.shoppingcart.entity;
import camt.se331.shoppingcart.dao.NewProductDao;
import camt.se331.shoppingcart.dao.ProductDao;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by kourin.pear on 24/2/2558.
 */
public class TestProduct {

    @Test
    public  void testProductGetNetPrice(){
        ProductDao product=new NewProductDao();
        VatEntity.getInstance().setVat(0.1);
        assertThat(product.getProduct(1l).getNetPrice(),is(900.00));

        VatEntity.getInstance().setVat(0.05);
        assertThat(product.getProduct(2l).getNetPrice(),is(1900.00));

        VatEntity.getInstance().setVat(0);
        assertThat(product.getProduct(3l).getNetPrice(),is(2500.00));

        VatEntity.getInstance().setVat(1);
        assertThat(product.getProduct(4l).getNetPrice(),is(0.00));


}
    @Test
    public void testProductGetVat(){
        ProductDao product=new NewProductDao();
        VatEntity.getInstance().setVat(0.1);
        assertThat(product.getProduct(1l).getTax(),is(100.00));

        VatEntity.getInstance().setVat(0.05);
        assertThat(product.getProduct(2l).getTax(),is(100.00));

        VatEntity.getInstance().setVat(0.0);
        assertThat(product.getProduct(3l).getTax(),is(0.00));

        VatEntity.getInstance().setVat(1);
        assertThat(product.getProduct(4l).getTax(),is(20000.00));

    }





}
