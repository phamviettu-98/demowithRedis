package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisCofig {
    @Value("${redis.host}")
    private String RedisHost;

    @Value("${redis.port}")
    private int RedisPort;
    // tao connect voi redis
    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory(){
        return  new LettuceConnectionFactory(new RedisStandaloneConfiguration(RedisHost, RedisPort));
    }

    @Bean
    @Primary
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
           RedisTemplate<Object, Object> template = new RedisTemplate<>();
           template.setConnectionFactory(redisConnectionFactory);
           return template;
    }
}
