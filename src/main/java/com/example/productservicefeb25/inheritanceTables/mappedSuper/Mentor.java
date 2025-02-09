package com.example.productservicefeb25.inheritanceTables.mappedSuper;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Mentor extends User{
    private int rating;
}


