package com.example.productservicefeb25.models;

import jakarta.persistence.*;

//@Entity

//@Table(name = "products")
public class Product extends BaseModel{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
    private String name;
    private double price;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
}
