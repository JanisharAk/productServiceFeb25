package com.example.productservicefeb25.controller;

import com.example.productservicefeb25.models.Product;
import com.example.productservicefeb25.service.ProductService;
import com.example.productservicefeb25.service.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService; ;

    public ProductController(ProductServiceImpl productService, ProductService productService1) {
        this.productService = productService1;
    }

    // GET: Retrieve all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
