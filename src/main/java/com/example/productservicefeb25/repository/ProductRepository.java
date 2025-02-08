package com.example.productservicefeb25.repository;

import com.example.productservicefeb25.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDTO, Long> {
}
