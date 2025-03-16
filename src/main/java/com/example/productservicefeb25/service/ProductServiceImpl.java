package com.example.productservicefeb25.service;

import com.example.productservicefeb25.dto.ProductDTO;
import com.example.productservicefeb25.exceptions.ProductNotFoundException;
import com.example.productservicefeb25.models.Product;
import com.example.productservicefeb25.repository.ProductRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final RedisTemplate<Long, Object> redisTemplate;

    public ProductServiceImpl(ProductRepository productRepository, RedisTemplate<Long, Object> redisTemplate) {
        this.productRepository = productRepository;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> products = productRepository.findAll();
        return products;
//        return products.stream()
//                .map(product -> new ProductDTO(product.getId(), product.getName(), product.getPrice()))
//                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long id) throws ProductNotFoundException {

        // Check Redis Cache
        ProductDTO cachedProduct = (ProductDTO) redisTemplate.opsForValue().get(id);
        if (cachedProduct != null) {
            return cachedProduct;
        }


        // Fetch from Database
        Optional<ProductDTO> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException("Product not found for id: " + id);
        }

        // Convert Entity to DTO
        ProductDTO productDTO = new ProductDTO();

        // Store in Redis Cache
        redisTemplate.opsForValue().set(id, productDTO);

        return productDTO;

    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        ProductDTO savedProduct = productRepository.save(productDTO);
        return savedProduct;
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        ProductDTO updatedProduct = productRepository.save(productDTO);
        return updatedProduct;
    }
}
