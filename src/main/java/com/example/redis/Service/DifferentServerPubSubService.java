// package com.example.redis.Service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.data.redis.connection.Message;
// import org.springframework.data.redis.connection.MessageListener;
// import org.springframework.data.redis.core.RedisTemplate;
// import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Service;

// import jakarta.annotation.PostConstruct;

// @Component
// public class DifferentServerPubSubService implements MessageListener  {


//     @Value("${channel1}")
//     private String channel1;

//     @Value("${channel2}")
//     private String channel2;
    

//     @Autowired
//     RedisTemplate redisTemplate;

//     @Autowired
//     RedisTemplate redisTemplate2;
    
//     // public DifferentServerPubSubService(String channel1, String channel2){
//     //     this.channel1=channel1;
//     //     this.channel2=channel2;
//     // }

//     @Override
//     public void onMessage(Message message, byte[] pattern) {
//        try {
//         String channel = new String(pattern);
//         String receivedMessage = new String(message.getBody());
//         System.out.println("Received message: " + receivedMessage + " from channel: " + channel);
//        } catch (Exception e) {
//         System.out.println("error  - "+e);
//        }
//     }

//     @PostConstruct
//     private void publishMessage(){
//         redisTemplate.convertAndSend(channel1, "publish on channel 1 on 192.168.8.143");
//         System.out.println("published  message on channel: " + channel1);

//         redisTemplate2.convertAndSend(channel1, "publish on channel 2 on redis server 192.168.8.124");
//         System.out.println("published  message on channel: " + channel2);
//     }



// }
