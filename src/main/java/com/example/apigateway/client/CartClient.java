package com.example.apigateway.client;//package com.example.apigateway.client;

import com.example.apigateway.model.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient("cart-service")
@Component
public interface CartClient {

    @GetMapping("/cart/{id}")
    @CrossOrigin
    Cart cart();

   @CrossOrigin
    @PostMapping("/cart")
    Cart saveCart(@RequestBody Cart cart);

}