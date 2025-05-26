package com.example.productservicefeb25.repository;

import com.example.productservicefeb25.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
