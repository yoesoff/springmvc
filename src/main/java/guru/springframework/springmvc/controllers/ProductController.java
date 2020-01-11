package guru.springframework.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.springframework.springmvc.domain.Product;
import guru.springframework.springmvc.services.ProductService;

/**
 * ProductController
 */
@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.listAllProducts());
        return "products";
    }

    @RequestMapping("/products/{id}")
    public String showProduct(@PathVariable Integer id , Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product";
    }

    @RequestMapping("/products/{id}/edit")
    public String editProduct(@PathVariable Integer id , Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "productForm";
    }

    @RequestMapping("/products/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "productForm";
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST )
    public String saveProduct(Product product) {
        Product savedProduct = this.productService.saveOrUpdate(product);

        return "redirect:/products/" + savedProduct.getId();
    }

}