package com.falcon.example.dockerspring.model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/docker/eda")
public class HelloWorld {
    @GetMapping
    public String hello(){
        return "Hello world";
    }
}
