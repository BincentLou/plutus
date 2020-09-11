package com.david.freedom.plutus.mvc;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version $Id: null.java, v 1.0 2020/9/9 11:32 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@Component
@ControllerAdvice
public class PlutusControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public void resolveException(HttpServletRequest request, HttpServletResponse response,Exception e){

        System.out.println("发生异常");
        response.setStatus(HttpServletResponse.SC_OK);

    }
}
