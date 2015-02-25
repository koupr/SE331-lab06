package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.dao.NewProductDao;
import camt.se331.shoppingcart.dao.ProductDao;
import camt.se331.shoppingcart.dao.SimpleProductDao;
import camt.se331.shoppingcart.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dto on 2/8/2015.
 */
@Service
public class ProductServiceImpl implements ProductService {

    ProductDao productDao=new SimpleProductDao();
    @Override
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    @Override
    public List<Product> getProducts(String anyKeyword) {
        return productDao.getProducts(anyKeyword);
    }

    @Override
    public Product getProduct(Long id) {
        return productDao.getProduct(id);
    }

    @Override
    public Product addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product product = getProduct(id);
        return productDao.deleteProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productDao.updateProduct(product);
    }
}
