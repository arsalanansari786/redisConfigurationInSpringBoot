// package com.example.redis.Configuration;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
// import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
// import org.springframework.data.redis.core.RedisTemplate;
// import org.springframework.data.redis.listener.ChannelTopic;
// import org.springframework.data.redis.listener.RedisMessageListenerContainer;
// import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
// import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
// import org.springframework.data.redis.serializer.StringRedisSerializer;

// import com.example.redis.Service.DifferentServerPubSubService;

// @Configuration
// public class DifferentServerPubSubConfig {

//     @Value("${channel1}")
//     private String channel1;

//     @Value("${channel2}")
//     private String channel2;

//     @Bean
//     public JedisConnectionFactory jedisConnectionFactory1() {
//         RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//         redisStandaloneConfiguration.setHostName("192.168.8.143");
//         redisStandaloneConfiguration.setPort(6379);
//         return new JedisConnectionFactory(redisStandaloneConfiguration);
//     }

//     @Bean
//     public JedisConnectionFactory jedisConnectionFactory2() {
//         RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//         redisStandaloneConfiguration.setHostName("192.168.8.124");
//         redisStandaloneConfiguration.setPort(6379);
//         return new JedisConnectionFactory(redisStandaloneConfiguration);
//     }


//     @Bean(name = "redisTemplate")
//     public RedisTemplate<String, String> redisTemplate1() {
//         RedisTemplate<String, String> template = new RedisTemplate<>();
//         template.setConnectionFactory(jedisConnectionFactory1());
//         template.setKeySerializer(new StringRedisSerializer());
//         template.setValueSerializer(new StringRedisSerializer());
//         return template;
//     }
//     @Bean(name = "redisTemplate2")
//     public RedisTemplate<String, Object> redisTemplate2() {
//         RedisTemplate<String, Object> template = new RedisTemplate<>();
//         template.setConnectionFactory(jedisConnectionFactory2());
//         template.setKeySerializer(new StringRedisSerializer());
//         template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//         return template;
//     }

//     @Bean
//     public RedisMessageListenerContainer redisMessageListenerContainer1(MessageListenerAdapter messageListenerAdapter) {
//         RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
//         redisMessageListenerContainer.setConnectionFactory(jedisConnectionFactory1());
//         redisMessageListenerContainer.addMessageListener(messageListenerAdapter, channelTopic1());
//         return redisMessageListenerContainer;

//     }

//     @Bean
//     public RedisMessageListenerContainer redisMessageListenerContainer2(MessageListenerAdapter messageListenerAdapter) {
//         RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
//         redisMessageListenerContainer.setConnectionFactory(jedisConnectionFactory2());
//         redisMessageListenerContainer.addMessageListener(messageListenerAdapter, channelTopic2());
//         return redisMessageListenerContainer;
//     }

//     @Bean
//     public MessageListenerAdapter messageListenerAdapter(DifferentServerPubSubService differentServerPubSubService) {
//         return new MessageListenerAdapter(differentServerPubSubService);
//     }

//     @Bean
//     public ChannelTopic channelTopic1() {
//         return new ChannelTopic(channel1);
//     }

//     @Bean
//     public ChannelTopic channelTopic2() {
//         return new ChannelTopic(channel2);
//     }

// }
