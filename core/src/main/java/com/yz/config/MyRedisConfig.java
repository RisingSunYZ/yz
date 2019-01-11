package com.yz.config;


import com.yz.model.Department;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class MyRedisConfig {
//
//    @Bean
//    public RedisTemplate deptRedisTemplate(RedisConnectionFactory redisConnectionFactory){
//        RedisTemplate<Object,Department> redisTemplate = new RedisTemplate();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        Jackson2JsonRedisSerializer<Department> serializer = new Jackson2JsonRedisSerializer(Department.class);
//        redisTemplate.setDefaultSerializer(serializer);
//        return redisTemplate;
//    }
//
//    @Primary
//    @Bean
//    public RedisCacheManager deptRedisCacheManager(RedisTemplate<Object,Department> deptRedisTemplate){
//        RedisCacheManager redisCacheManager = new RedisCacheManager(deptRedisTemplate);
//        return redisCacheManager;
//    }


}
