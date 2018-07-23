package com.falcon.example.dockerspring;

import com.falcon.example.dockerspring.model.Product;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private RedisTemplate<String,Product> redisTemplate;
    private HashOperations hashOperations;

    public ProductRepositoryImpl(RedisTemplate<String, Product> redisTemplate, HashOperations hashOperations) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Product product) {
        hashOperations.put("PRODUCT", product.getId(), product );
    }

    @Override
    public Map<String,Product> getAll() {
        return hashOperations.entries("PRODUCT");
    }

    @Override
    public void update(Product product) {
        save(product);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("PRODUCT",id);
    }

    @Override
    public Product findById(String id) {
        return (Product) hashOperations.get("PRODUCT",id);


    }
}
