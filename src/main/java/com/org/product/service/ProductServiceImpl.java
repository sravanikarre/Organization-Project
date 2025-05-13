package com.org.product.service;


import com.org.product.dao.ProductRepository;
import com.org.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    //viswa
    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }


    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Product not found with id" + id));
    }

    @Override
    public void updateProduct(Long id, Product updateProduct) {

        Product product = getProductById(id);
        product.setProductName(updateProduct.getProductName());
        product.setProductPrice(updateProduct.getProductPrice());

        productRepository.save(product);

    }


    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}