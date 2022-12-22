package com.example.apigateway.model;

import lombok.Data;

@Data
public class LineItem {
    private Integer id;
    private String productName;
    private Integer quantity;
    private double price;
}