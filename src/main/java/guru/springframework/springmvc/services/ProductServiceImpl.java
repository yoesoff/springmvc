package guru.springframework.springmvc.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
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

    private Map<Integer, Product> products;

    public ProductServiceImpl() {
        loadProducts();
    }

    @Override
    public List<Product> listAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getProductById(Integer id) {
        return products.get(id);
    }

    @Override
    public Product saveOrUpdate(Product product) {
        if (product!=null) {
            if (product.getId() == null){
                product.setId(getNextKey());
            }
            
            this.products.put(product.getId(), product);
            return product;
        }
        
        throw new RuntimeException("Error kawan!");
        
    }

    private Integer getNextKey(){
        return Collections.max(products.keySet()) + 1;
    }      
    
    public void loadProducts() {
        products = new HashMap<>();

        Product product1 = new Product(1, "Product 1 lorem ipsum", new BigDecimal("22"), "lorem");
        products.put(1, product1);

        Product product2 = new Product(2, "Product 2 lorem ipsum", new BigDecimal("23"), "http://example.com/product2");
        products.put(2, product2);

        Product product3 = new Product(3, "Product 3 lorem ipsum", new BigDecimal("25"), "http://example.com/product3");
        products.put(3, product3);

        Product product4 = new Product(4, "Product 4 lorem ipsum", new BigDecimal("40"), "http://example.com/product4");
        products.put(4, product4);
    }
}