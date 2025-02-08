package com.example.productservicefeb25.models;

import jakarta.persistence.*;

@Entity

public class Product extends BaseModel{
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

}
