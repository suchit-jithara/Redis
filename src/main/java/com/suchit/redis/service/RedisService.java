package com.suchit.redis.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String get(String key) {
        Object v = redisTemplate.opsForValue().get(key);
        return v != null ? v.toString() : null;
    }

    @Cacheable(value = "userCache", key = "#id")
    public String getUserById(int id) {
        System.out.println(">>> Fetching from DB for userId = " + id);
        return "User_" + id;
    }
}
