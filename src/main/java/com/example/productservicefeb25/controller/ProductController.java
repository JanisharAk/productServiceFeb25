package com.example.productservicefeb25.controller;

import com.example.productservicefeb25.dto.ExceptionDTO;
import com.example.productservicefeb25.dto.ProductDTO;
import com.example.productservicefeb25.exceptions.ProductNotFoundException;
import com.example.productservicefeb25.models.Product;
import com.example.productservicefeb25.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService ;
    }

    // GET: Retrieve all products
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    // GET: Retrieve a product by ID
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    // POST: Add a new product
    @PostMapping
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);  //  Passed product to service method
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO) {
        productDTO.setId(id); // Ensure the correct ID is set
        //ProductDTO updatedProduct = productService.updateProduct(productDTO);
        return productService.updateProduct(productDTO);
    }


//    @ExceptionHandler(ProductNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)//it changes the status in postman from 200ok to 404 not found
//    @ResponseBody
//    private ExceptionDTO handleProductNotFoundException(ProductNotFoundException e) {
//        ExceptionDTO exceptionDTO = new ExceptionDTO();
//        exceptionDTO.setMessage(e.getMessage());
//        exceptionDTO.setStatus("Failure");
//        return exceptionDTO;
//        //here it is violating SRP so we need to create this in separate class called ProductControllerAdvice
//
//    }
}
