package guru.springframework.springmvc.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import guru.springframework.springmvc.domain.Product;

/**
 * ProductServiceImpl
 */
@Service
public class ProductServiceImpl implements ProductService {

    private Map<Integer, Product> product;

    @Override
    public List<Product> listAllProducts() {
        return new ArrayList<>(product.values());
    }

    public void loadProducts() {
        product = new HashMap<>();

        Product product1 = new Product(1, "Product 1 lorem ipsum", new BigDecimal("22"), "lorem");
        product.put(1, product1);

        Product product2 = new Product(2, "Product 2 lorem ipsum", new BigDecimal("22"), "http://example.com/product2");
        product.put(2, product2);

        Product product3 = new Product(3, "Product 3 lorem ipsum", new BigDecimal("22"), "http://example.com/product3");
        product.put(3, product3);

        Product product4 = new Product(4, "Product 4 lorem ipsum", new BigDecimal("22"), "http://example.com/product4");
        product.put(4, product4);
    }

}