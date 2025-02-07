package com.example.productservicefeb25.controller;

import com.example.productservicefeb25.models.Product;
import com.example.productservicefeb25.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService ;
    }

    // GET: Retrieve all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
