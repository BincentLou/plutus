package com.david.freedom.plutus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * @version $Id: null.java, v 1.0 2020/9/15 11:16 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory(){

        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("127.0.0.1",6379);
        return new JedisConnectionFactory(configuration);
    }

    // @Bean
    // public RedisTemplate redisTemplate(){
    //     RedisTemplate redisTemplate = new RedisTemplate();
    //     return redisTemplate;
    // }
}
