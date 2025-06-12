package com.example.productservicefeb25.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductEventDto {
    private String eventType; // "CREATE", "UPDATE", "DELETE"
    private Long productId;
    private String productName;
    private String recipientEmail; // Could be admin email or customer email
    private String message;
}