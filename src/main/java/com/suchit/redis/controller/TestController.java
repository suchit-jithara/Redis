package com.suchit.redis.controller;

import com.suchit.redis.service.RedisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class TestController {

    private final RedisService redisService;

    public TestController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/set/{key}/{value}")
    public String set(@PathVariable String key, @PathVariable String value) {
        redisService.set(key, value);
        return "OK";
    }

    @GetMapping("/get/{key}")
    public String get(@PathVariable String key) {
        return redisService.get(key);
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable int id) {
        return redisService.getUserById(id);
    }
}
