package com.falcon.example.dockerspring;

import com.falcon.example.dockerspring.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductRepository {
    void save(Product product);
    Map<String,Product> getAll();
    void update(Product product);
    void delete(String id);
    Product findById(String id);
}
