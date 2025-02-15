package com.example.productservicefeb25.controller;

import com.example.productservicefeb25.dto.ProductDTO;
import com.example.productservicefeb25.exceptions.ProductNotFoundException;
import com.example.productservicefeb25.models.Product;
import com.example.productservicefeb25.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mockito;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @InjectMocks
    private ProductController productController; // Inject controller

    @Mock
    private ProductService productService = Mockito.mock(ProductService.class); // Use @TestBean in Spring Boot 3.2+

    @Test
    void getProductById() throws ProductNotFoundException {
        // Arrange
        ProductDTO dummyDTO = new ProductDTO();
        dummyDTO.setId(1L);
        dummyDTO.setName("dummy");

        // Correctly mock service method
        when(productService.getProductById(1L)).thenReturn(dummyDTO);

        // Act
        ProductDTO result = productController.getProductById(1L);

        // Assert
        assertEquals(1L, result.getId());
        assertEquals("dummy", result.getName());
    }
}
