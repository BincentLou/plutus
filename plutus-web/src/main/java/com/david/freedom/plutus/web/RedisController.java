package com.david.freedom.plutus.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.freedom.plutus.biz.service.RedisService;

/**
 * @version $Id: null.java, v 1.0 2020/9/15 4:25 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@RestController
public class RedisController {

    @Autowired
    RedisService redisService;

    @RequestMapping("/getAtomicInteger")
    public Integer getAtomicInteger(){
        return redisService.getAtomicInteger();
    }
}
