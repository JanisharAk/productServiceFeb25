package com.example.productservicefeb25.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
@Entity

public class Product extends BaseModel implements Serializable {
    private String name;
    private double price;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

}
