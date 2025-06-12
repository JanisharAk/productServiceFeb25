package com.example.productservicefeb25.controller;

import com.example.productservicefeb25.dto.ProductEventDto;
import com.example.productservicefeb25.exceptions.ProductNotFoundException;
import com.example.productservicefeb25.models.Product;
import com.example.productservicefeb25.service.ProductEventProducer;
import com.example.productservicefeb25.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final ProductEventProducer productEventProducer;

    @Autowired
    public ProductController(ProductService productService,
                             ProductEventProducer productEventProducer) {
        this.productService = productService;
        this.productEventProducer = productEventProducer;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);

        ProductEventDto event = new ProductEventDto();
        event.setEventType("CREATE");
        event.setProductId(savedProduct.getId());
        event.setProductName(savedProduct.getName()); // Using correct getName()
        event.setRecipientEmail("admin@example.com");
        event.setMessage(String.format("New product created: %s (Price: $%.2f)",
                savedProduct.getName(), savedProduct.getPrice()));

        try {
            productEventProducer.sendProductEvent(event);
        } catch (JsonProcessingException e) {
            System.err.println("Failed to send product creation event: " + e.getMessage());
        }

        return savedProduct;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        try {
            Product product = productService.getProductById(id);

            ProductEventDto event = new ProductEventDto();
            event.setEventType("DELETE");
            event.setProductId(product.getId());
            event.setProductName(product.getName());
            event.setRecipientEmail("admin@example.com");
            event.setMessage(String.format("Product deleted: %s (ID: %d)",
                    product.getName(), product.getId()));

            try {
                productEventProducer.sendProductEvent(event);
            } catch (JsonProcessingException e) {
                System.err.println("Failed to send product deletion event: " + e.getMessage());
            }

            productService.deleteProductById(id);
        } catch (ProductNotFoundException e) {
            System.err.println("Product not found for deletion: " + id);
            throw e;
        }
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        product.setId(id);
        Product updatedProduct = productService.updateProduct(product);

        ProductEventDto event = new ProductEventDto();
        event.setEventType("UPDATE");
        event.setProductId(updatedProduct.getId());
        event.setProductName(updatedProduct.getName());
        event.setRecipientEmail("admin@example.com");
        event.setMessage(String.format("Product updated: %s (New price: $%.2f)",
                updatedProduct.getName(), updatedProduct.getPrice()));

        try {
            productEventProducer.sendProductEvent(event);
        } catch (JsonProcessingException e) {
            System.err.println("Failed to send product update event: " + e.getMessage());
        }

        return updatedProduct;
    }
}