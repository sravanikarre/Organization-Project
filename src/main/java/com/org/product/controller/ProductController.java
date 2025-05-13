package com.org.product.controller;


import com.org.product.entity.Product;
import com.org.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {

    @Autowired
    private ProductService productService;

    //viswa
    @GetMapping("getallproduct")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("addproduct")

    public void addProducts(@RequestBody Product product) {
        productService.saveProduct(product);
    }


    @PutMapping("{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product) {

        productService.updateProduct(id, product);
    }


    @DeleteMapping("{id}")
    public void removeProduct(@PathVariable Long id) {

        productService.deleteProduct(id);
    }

}

