package com.example.productservicefeb25.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModel {
    @Id
    private Long id;
}
