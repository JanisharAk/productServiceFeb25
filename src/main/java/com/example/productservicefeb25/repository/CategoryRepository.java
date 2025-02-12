package com.example.productservicefeb25.repository;

import com.example.productservicefeb25.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}