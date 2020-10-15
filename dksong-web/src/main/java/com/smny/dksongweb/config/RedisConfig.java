package com.smny.dksongweb.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Classname RedisConfig
 * @Description redis配置
 * @Date 2019/10/20 15:34
 * @Created by yuan jing
 */
@Configuration
@Slf4j
public class RedisConfig {

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory redisConnectionFactory){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
//        container.addMessageListener(new RedisExpiredListener(), new PatternTopic("__keyevent@0__:expired"));
        return container;
    }
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        //StringRedisTemplate的构造方法中默认设置了stringSerializer
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        //set key serializer
        template.setKeySerializer(stringRedisKeySerializer());
        template.setHashKeySerializer(stringRedisKeySerializer());

        //set value serializer
        template.setDefaultSerializer(jackson2JsonRedisSerializer());
        template.setValueSerializer(jackson2JsonRedisSerializer());
        template.setHashValueSerializer(jackson2JsonRedisSerializer());

        template.setConnectionFactory(redisConnectionFactory);
        template.afterPropertiesSet();
        log.info("RedisTemplate 初始化完成.......");
        return template;
    }

    /**
     * @description: 注入 ioc 容器 StringRedisTemplate
     * @param: RedisConnectionFactory
     * @author: yuan jing
     * @date: 2019/10/20
     */
    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    /**
     * @description: 使用 StringRedisKeySerializer 来序列化和反序列化 redis的 key 值
     * @author: yuan jing
     * @date: 2019/10/20
     */
    private RedisSerializer<String> stringRedisKeySerializer() {
        return new StringRedisSerializer();
    }


    /**
     * @description: 使用Jackson2JsonRedisSerializer 来序列化和反序列化redis的value值
     * @author: yuan jing
     * @date: 2019/10/20
     */
    private RedisSerializer<Object> jackson2JsonRedisSerializer() {
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(mapper);
        return serializer;
    }

}
