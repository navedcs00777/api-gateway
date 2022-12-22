package com.example.apigateway.client;

import com.example.apigateway.model.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("car-service")
public interface CarClient {

    @GetMapping("/cars")
    @CrossOrigin
    CollectionModel<Car> readCars();

    @GetMapping("/token")
    @CrossOrigin
    String token();

}