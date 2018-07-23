package com.falcon.example.dockerspring.controller;

import com.falcon.example.dockerspring.ProductRepository;
import com.falcon.example.dockerspring.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest/docker/products")
public class ProductResource {
    private ProductRepository productRepository;

    public ProductResource(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping("/add/{id}/{name}")
    public Product add(@PathVariable("id") final String id,
                    @PathVariable("name") final String name){
        productRepository.save(new Product(id,name,10000L));
        return productRepository.findById(id);
    }

    @GetMapping("/udpate/{id}/{name}")
    public Product update(@PathVariable("id") final String id,
                       @PathVariable("name") final String name){
        productRepository.update(new Product(id,name,20000L));
        return productRepository.findById(id);
    }
    @GetMapping("/all")
    public Map<String,Product> update(){
        return productRepository.getAll();
    }
}
