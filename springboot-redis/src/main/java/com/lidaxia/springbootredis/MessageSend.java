package com.lidaxia.springbootredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author lijiannan
 * @desc
 * @date 2021/12/3 11:05（
 */
@Component
public class MessageSend {

    @Autowired
    private RedisTemplate redisTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage(){
        System.out.println("sendMessage");
        redisTemplate.convertAndSend("topic1",String.valueOf(Math.random()));
    }
}