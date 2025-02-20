// package com.example.redis.Configuration;

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

// import com.example.redis.Service.SameServerPubSubService;

// @Configuration
// public class SameServerPubSubConfig {

//     @Value("${channel1}")
//     private String channel1;

//     @Value("${channel2}")
//     private String channel2;

//     @Bean(name = "jedisConnectionFactoryPub")
//     public JedisConnectionFactory jedisConnectionFactoryPub() {
//         RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//         redisStandaloneConfiguration.setHostName("192.168.8.143");
//         redisStandaloneConfiguration.setPort(6379);
//         return new JedisConnectionFactory(redisStandaloneConfiguration);
//     }

//     @Bean(name = "jedisConnectionFactorySub")
//     public JedisConnectionFactory jedisConnectionFactorySub() {
//         RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//         redisStandaloneConfiguration.setHostName("192.168.8.143");
//         redisStandaloneConfiguration.setPort(6379);
//         return new JedisConnectionFactory(redisStandaloneConfiguration);
//     }

//     @Bean(name = "redisTemplatePub")
//     public RedisTemplate<String, Object> redisTemplatePub() {
//         RedisTemplate<String, Object> template = new RedisTemplate<>();
//         template.setConnectionFactory(jedisConnectionFactoryPub());
//         template.setKeySerializer(new StringRedisSerializer());
//         template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//         return template;
//     }

//     @Bean(name = "redisTemplateSub")
//     public RedisTemplate<String, Object> redisTemplateSub() {
//         RedisTemplate<String, Object> template = new RedisTemplate<>();
//         template.setConnectionFactory(jedisConnectionFactorySub());
//         template.setKeySerializer(new StringRedisSerializer());
//         template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//         return template;
//     }

//     @Bean
//     public RedisMessageListenerContainer redisMessageListenerContainer(MessageListenerAdapter messageListenerAdapter) {
//         RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
//         redisMessageListenerContainer.setConnectionFactory(jedisConnectionFactorySub());
//         redisMessageListenerContainer.addMessageListener(messageListenerAdapter, channelTopic1());
//         return null;

//     }

//     @Bean
//     public SameServerPubSubService messageListener() {
//         return new SameServerPubSubService();
//     }

//     @Bean
//     public MessageListenerAdapter messageListenerAdapter(SameServerPubSubService serviceMessageListener) {
//         return new MessageListenerAdapter(serviceMessageListener);
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
