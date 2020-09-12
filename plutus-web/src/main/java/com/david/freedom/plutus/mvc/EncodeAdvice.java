package com.david.freedom.plutus.mvc;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @version $Id: null.java, v 1.0 2020/9/11 3:24 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:
 * @since 1.0
 **/
@RestControllerAdvice
public class EncodeAdvice {

    @InitBinder
    public void enCodeResponse(){

    }
}
