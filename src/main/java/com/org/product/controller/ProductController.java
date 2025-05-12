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

    @GetMapping("getallproduct")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

        @PostMapping("/createproduct")
        public void createProduct(@RequestBody Product product) {
            System.out.println("product name"+ product.getProductName());
            System.out.println("product price"+ product.getProductPrice());

            productService.saveProduct(product);
        }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }


    }

