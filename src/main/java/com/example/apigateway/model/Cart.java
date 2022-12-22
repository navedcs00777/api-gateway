package com.example.apigateway.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {

    private Integer id;
    private String customerId;
    private double total;
    private List<LineItem> lineItems = new ArrayList<>();

}