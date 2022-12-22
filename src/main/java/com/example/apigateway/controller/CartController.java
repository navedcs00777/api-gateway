package com.example.apigateway.controller;

import com.example.apigateway.client.CartClient;
import com.example.apigateway.model.Cart;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    private CartClient cartClient;

    public CartController(CartClient cartClient) {
        this.cartClient = cartClient;
    }


    @GetMapping("/cart/{id}")
    @HystrixCommand(fallbackMethod = "fallback")
    @CrossOrigin
    public Cart getCart(@PathVariable Integer id){
        return cartClient.cart();
    }

    @PostMapping("/cart")
    @HystrixCommand(fallbackMethod = "fallback")
    @CrossOrigin
    public Cart saveCart(@RequestBody  Cart cart){
        Cart saved = cartClient.saveCart(cart);

        return saved;
    }

}
