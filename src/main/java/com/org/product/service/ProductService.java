package com.org.product.service;


import com.org.product.entity.Product;

import java.util.List;

public interface ProductService {

    void saveProduct(Product product);

    //viswa
    List<Product> getAllProducts();
   Product getProductById(Long id);

    void updateProduct(Long id, Product product);
    void deleteProduct(Long id);

   


}
