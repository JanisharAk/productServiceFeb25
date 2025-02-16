package com.example.productservicefeb25.controller;

import com.example.productservicefeb25.dto.ProductDTO;
import com.example.productservicefeb25.exceptions.ProductNotFoundException;
import com.example.productservicefeb25.models.Product;
import com.example.productservicefeb25.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mockito;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductControllerTest {

    @InjectMocks
    private ProductController productController; // Inject controller

    @Mock
    private ProductService productService; //= Mockito.mock(ProductService.class);

    private ProductDTO dummyDTO;
    @BeforeEach
    void setUp() {
        dummyDTO = new ProductDTO(); // Ensure dummyDTO is initialized before each test
        dummyDTO.setId(1L);
        dummyDTO.setName("dummy");
    }
    @Test
    void getProductById() throws ProductNotFoundException {
        // Arrange
//        ProductDTO dummyDTO = new ProductDTO();
//        dummyDTO.setId(1L);
//        dummyDTO.setName("dummy");

        // Correctly mock service method
        when(productService.getProductById(1L)).thenReturn(dummyDTO);

        // Act
        ProductDTO result = productController.getProductById(1L);

        // Assert
        assertEquals(1L, result.getId());
        assertEquals("dummy", result.getName());
    }

    @Test
    void  getAllProducts(){
        // Arrange
//        ProductDTO dummyDTO = new ProductDTO();
//        dummyDTO.setId(1L);
//        dummyDTO.setName("dummy");

        List<ProductDTO> productList = Arrays.asList(dummyDTO);
        when(productService.getAllProducts()).thenReturn(productList);

        List<ProductDTO> result = productController.getAllProducts();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("dummy", result.get(0).getName());
    }

    @Test
    void saveProduct() {
        // Arrange
//        ProductDTO dummyDTO = new ProductDTO();
//        dummyDTO.setId(1L);
//        dummyDTO.setName("dummy");

        when(productService.saveProduct(dummyDTO)).thenReturn(dummyDTO);
        ProductDTO result = productController.addProduct(dummyDTO);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }
    @Test
    void deleteProduct() {
//        ProductDTO dummyDTO = new ProductDTO();
//        dummyDTO.setId(1L);
//        dummyDTO.setName("dummy");

        doNothing().when(productService).deleteProductById(1L);
        assertDoesNotThrow(() -> productController.deleteProduct(1L));
        verify(productService, times(1)).deleteProductById(1L);
    }
    @Test
    void updateProduct() {
//        ProductDTO dummyDTO = new ProductDTO();
//        dummyDTO.setId(1L);
//        dummyDTO.setName("dummy");

        when(productService.updateProduct(dummyDTO)).thenReturn(dummyDTO);
        ProductDTO result = productController.updateProduct(1L,dummyDTO);
        assertNotNull(result);
        assertEquals("dummy", result.getName());
    }
}
