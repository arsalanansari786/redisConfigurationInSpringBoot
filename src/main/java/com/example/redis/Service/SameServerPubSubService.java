// package com.example.redis.Service;

// import org.springframework.data.redis.connection.Message;
// import org.springframework.data.redis.connection.MessageListener;

// public class SameServerPubSubService implements MessageListener {

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
// }

