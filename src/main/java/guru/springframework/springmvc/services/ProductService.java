package guru.springframework.springmvc.services;

import guru.springframework.springmvc.domain.Product;

import java.util.List;

/**
 * Created by jt on 11/6/15.
 */
public interface ProductService {

    List<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveOrUpdate(Product product);

    Integer deleteById(Integer id);
}
}