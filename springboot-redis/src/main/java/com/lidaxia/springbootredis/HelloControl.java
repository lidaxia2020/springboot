package com.lidaxia.springbootredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lidaxia
 * @desc
 * @date 2021/12/3 11:13（
 */
@RestController
public class HelloControl {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("test")
    public String test() {
        redisTemplate.convertAndSend("topic1", String.valueOf(Math.random()));
        return "success";
    }
}
