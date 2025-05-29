package com.example.productservicefeb25.service;

import com.example.productservicefeb25.exceptions.ProductNotFoundException;
import com.example.productservicefeb25.models.Product;
import com.example.productservicefeb25.repository.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
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
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @Cacheable(value = "products", key = "#id")
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {

        // Check Redis Cache
        Product cachedProduct = (Product) redisTemplate.opsForValue().get(id);
        if (cachedProduct != null) {
            return cachedProduct;
        }


        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found for id: " + id));


        redisTemplate.opsForValue().set(id, product);// cache the product
        return product;

    }
    @CachePut(value = "products", key = "#result.id")
    @Override
    public Product saveProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        redisTemplate.opsForValue().set(savedProduct.getId(), savedProduct);  // Cache the saved product
        return savedProduct;
    }
    @CacheEvict(value = "products", key = "#id")
    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
        redisTemplate.delete(id);  // Clean cache on delete
    }
    @CachePut(value = "products", key = "#product.id")
    @Override
    public Product updateProduct(Product product) {
        Product updatedProduct = productRepository.save(product);
        redisTemplate.opsForValue().set(updatedProduct.getId(), updatedProduct);  // Update cache
        return updatedProduct;
    }
}
