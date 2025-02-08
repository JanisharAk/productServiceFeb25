package com.example.productservicefeb25.service;

import com.example.productservicefeb25.dto.ProductDTO;
import com.example.productservicefeb25.models.Product;
import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Long id);
    ProductDTO saveProduct(ProductDTO productDTO);
    void deleteProductById(Long id);
    ProductDTO updateProduct(ProductDTO productDTO);
}
