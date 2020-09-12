package com.david.freedom.plutus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @version $Id: null.java, v 1.0 2020/9/3 8:29 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:启动类
 * @since 1.0
 **/
@SpringBootApplication
@MapperScan(value = "com.david.freedom.plutus.dao")
@EnableScheduling
public class PlutusApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(PlutusApplication.class)
                .run(args);
    }

}
