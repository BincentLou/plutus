package com.david.freedom.plutus.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;
import org.springframework.stereotype.Component;

import com.david.freedom.plutus.biz.service.RedisService;

/**
 * @version $Id: null.java, v 1.0 2020/9/15 4:27 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@Component
public class RedisServiceImpl implements RedisService {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public Integer getAtomicInteger() {
        RedisAtomicInteger atomicInteger = new RedisAtomicInteger("AAAAA",redisTemplate.getConnectionFactory());
        int a = atomicInteger.getAndIncrement();
        System.out.println("————————————————————————————————");
        System.out.println(a);
        return a;
    }
}
