package camt.se331.shoppingcart.entity;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.TestContextManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junitparams.JUnitParamsRunner.$;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
/**
 * Created by Dto on 2/7/2015.
 */

@RunWith(JUnitParamsRunner.class)
public class ShoppingCartTest {

    private TestContextManager testContextManager;
    // initiate parameterize testing


    @Test
    @Parameters(method = "parameterForTestGetTotalProductPrice")
    public void TestGetTotalProductPrice(List<SelectedProduct> productList, Double expectedResult){
        ShoppingCart sc = new ShoppingCart(productList);
        assertThat(sc.getTotalProductPrice(),is(expectedResult));
    }

    public Object[] parameterForTestGetTotalProductPrice(){
        Product p1 =  new Product(1l,"iphone 6","The worst iphone ever",25000.00);
        Product p2 = new Product(2l, "Note II","The old",6500.00);
        Product p3 = new Product (3l, "Chair", "Older chair",250.00 );
        return $(
                $(Arrays.asList(new SelectedProduct(p1,0),
                        new SelectedProduct(p2,0),
                        new SelectedProduct(p3,0)),0.0),
                $(Arrays.asList(new SelectedProduct(p1, 1),
                        new SelectedProduct(p2, 1),
                        new SelectedProduct(p3, 1)), 31750.00),
                $(Arrays.asList(new SelectedProduct(p1, 1),
                        new SelectedProduct(p2, 3)), 44500.00)
        );
    }


    @Test
    public void testGetTotalProductPriceUsingMock() {
        Product p = mock(Product.class);
        when(p.getTotalPrice()).thenReturn(1000.0);
        SelectedProduct sp = new SelectedProduct(p,0);
        assertThat(sp.getTotalPrice(),is(0.0));
        when(p.getTotalPrice()).thenReturn(2500.00);
        sp.setProduct(p);
        sp.setAmount(10);
        when(p.getTotalPrice()).thenReturn(25000.00);
    }

    @Test
    public void testTest(){
        SelectedProduct sp1 = mock(SelectedProduct.class);
        SelectedProduct sp2 = mock(SelectedProduct.class);

        when(sp1.getTotalPrice()).thenReturn(200.00);
        when(sp2.getTotalPrice()).thenReturn(300.00);

        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(sp1,sp2));
        assertThat(shoppingCart.getTotalProductPrice(),is(500.0));
    }





}
