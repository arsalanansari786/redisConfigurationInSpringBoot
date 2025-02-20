package com.example.redis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class SingleDatabaseService {

    @Autowired
    RedisTemplate redisTemplate;



    @PostConstruct
    private void sendDetails(){
        redisTemplate.opsForValue().set("helloredis1", "I am sending to 192.168.8.143");
        System.out.println("Done on 192.168.8.143  -");
    }


    @PostConstruct
    private void loadDetails(){
        try {
            String data= redisTemplate.opsForValue().get("helloredis1").toString();
            System.out.println("Loaded from Database in SingleDatabaseService from 192.168.8.143  -");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
