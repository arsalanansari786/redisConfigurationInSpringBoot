// package com.example.redis.Service;

// import java.util.Scanner;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.data.redis.core.RedisTemplate;
// import org.springframework.stereotype.Service;

// import jakarta.annotation.PostConstruct;


// @Service
// public class DifferentServerMultipleDatabaseService {

//     @Autowired
//     RedisTemplate redisTemplate;

//     @Autowired
//     RedisTemplate redisTemplate2;

//     @PostConstruct
//     private void details(){
//         redisTemplate.opsForValue().set("helloxx", "arslan1");
//         System.out.println("Done on 192.168.8.143  -");
//         redisTemplate2.opsForValue().set("hello2", "arslan2");
//         System.out.println("Done on 192.168.8.124  -");
//     }

// }
