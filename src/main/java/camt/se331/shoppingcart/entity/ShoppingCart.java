package camt.se331.shoppingcart.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Dto on 2/7/2015.
 */
public class ShoppingCart {
    List<SelectedProduct> selectedProducts;
    Date purchaseDate;

    public double getTotalProductPrice(){
        double totalPrice=0.0;
        for(int i=0;i<selectedProducts.size();i++){
            totalPrice+=(selectedProducts.get(i).getAmount()*selectedProducts.get(i).getTotalPrice());
        }
        return totalPrice;
    };

    public List<SelectedProduct> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<SelectedProduct> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public ShoppingCart(List<SelectedProduct> selectedProducts) {

        this.selectedProducts = selectedProducts;
    }

    public ShoppingCart() {

    }
}
