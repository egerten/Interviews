package com.falcon.example.dockerspring;

import com.falcon.example.dockerspring.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class DockerSpringApplication {
	@Bean
	JedisConnectionFactory jedisConnectionFactory(){
		return new JedisConnectionFactory();
	}
	@Bean
	RedisTemplate<String,Product> redisTemplate(){
		RedisTemplate<String, Product> redisTemplate = new RedisTemplate<String, Product>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
	public static void main(String[] args) {
		SpringApplication.run(DockerSpringApplication.class, args);
	}
}
