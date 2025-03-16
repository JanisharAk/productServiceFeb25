package com.example.productservicefeb25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;
@Entity
public class Category extends BaseModel implements Serializable {
    private String categoryName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private List<Product> products;
}
