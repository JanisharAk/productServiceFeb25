package com.example.productservicefeb25.service;

import com.example.productservicefeb25.dto.ProductDTO;
import com.example.productservicefeb25.models.Product;
import com.example.productservicefeb25.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
    public ProductDTO getProductById(Long id) {
        Optional<ProductDTO> product = productRepository.findById(id);
        return product.isPresent() ? product.get() : new ProductDTO();
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
}
