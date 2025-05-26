package com.example.productservicefeb25.service;

import com.example.productservicefeb25.exceptions.ProductNotFoundException;
import com.example.productservicefeb25.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id) throws ProductNotFoundException;
    Product saveProduct(Product productDTO);
    void deleteProductById(Long id);
    Product updateProduct(Product productDTO);
}
