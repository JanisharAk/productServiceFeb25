package com.example.productservicefeb25.models;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Category extends BaseModel {
    private String categoryName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private List<Product> products;
}
