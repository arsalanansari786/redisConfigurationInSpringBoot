// This is redis configuration as a database .If we are making single connectionn



package com.example.redis.Configuration;

import org.springframework.boot.autoconfigure.cache.CacheProperties.Redis;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class SingleDatabaseConfig {
    
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration=new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName("192.168.8.143");
        redisStandaloneConfiguration.setPort(6379);
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean(name="redisTemplate")
    public RedisTemplate<String ,Object>redisTemplate(){
        RedisTemplate<String,Object> template =new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }

}

// Manual Confgiuration of redis as a database 
// GenericJackson2JsonRedisSerializer
// ✅ Pros:
// ✔ Stores data in a readable JSON format.
// ✔ Works well with generic objects (does not require specifying types).
// ✔ Can store nested objects properly.

// ❌ Cons:

// Bigger payload size (JSON is larger than binary formats).
// Requires Jackson dependency.
// If class structure changes, deserialization can fail.

// StringRedisSerializer
// ✅ Pros:
// ✔ Fastest serializer (no conversion overhead).
// ✔ Lightweight (no extra dependencies).
// ✔ Easy to debug because data is stored as plain strings.

// ❌ Cons:

// Cannot store complex objects (only strings).
// Does not support nested objects.


// GenericToStringSerializer<>(null)
// ✅ Pros:
// ✔ Simple and lightweight.
// ✔ Works well with numbers and simple objects.

// ❌ Cons:

// Does not work well with nested or complex objects.
// Requires explicit conversion when retrieving values.

// Jackson2JsonRedisSerializer<>(null)
// ✅ Pros:
// ✔ Smaller payload compared to GenericJackson2JsonRedisSerializer.
// ✔ Supports custom serialization settings (e.g., ignoring null fields).

// ❌ Cons:

// Tightly coupled to a specific class (MyObject.class).
// Breaks if the class structure changes.


// JdkSerializationRedisSerializer
// ✅ Pros:
// ✔ Works out-of-the-box with Java objects.
// ✔ No need for external dependencies.

// ❌ Cons:

// Not human-readable (stores binary data).
// Not language-independent (only works with Java).
// Consumes more space compared to JSON serializers.

// OxmSerializer
// ✅ Pros:
// ✔ Useful for XML-based applications.
// ✔ Works with JAXB annotations.

// ❌ Cons:

// Larger payload size than JSON.
// Slower than JSON and binary formats.


