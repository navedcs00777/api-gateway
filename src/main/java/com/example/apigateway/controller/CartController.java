package com.example.apigateway.controller;

import com.example.apigateway.client.CartClient;
import com.example.apigateway.model.Cart;
import com.example.apigateway.model.LineItem;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@Slf4j
public class CartController {

    @Autowired
    private CartClient cartClient;

    public CartController(CartClient cartClient) {
        this.cartClient = cartClient;
    }

    private Cart fallback(Integer id) {
        return new Cart();
    }

    @GetMapping("/cart/{id}")
    @HystrixCommand(fallbackMethod = "fallback")
    @CrossOrigin
    public Cart getCart(@PathVariable Integer id){
        log.info("Loading the Data...");
        return cartClient.cart();
    }

    @PostMapping("/cart")
    @HystrixCommand(fallbackMethod = "fallback")
    @CrossOrigin
    public Cart saveCart(@RequestBody  Cart cart){

        cart = new Cart();
        LineItem item = new LineItem();
        item.setId(1);
        item.setPrice(14000.0);
        item.setQuantity(1);
        item.setProductName("Mobile Phone");
        cart.getLineItems().add(item);
        cart.setId(1);
        cart.setCustomerId("CS0111");
        cart.setTotal(14000.0);

        Cart saved = cartClient.saveCart(cart);


        return saved;
    }

}
