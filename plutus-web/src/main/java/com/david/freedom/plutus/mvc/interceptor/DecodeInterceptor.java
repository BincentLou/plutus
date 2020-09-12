package com.david.freedom.plutus.mvc.interceptor;

import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;

/**
 * @version $Id: null.java, v 1.0 2020/9/11 3:16 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class DecodeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(" 前置处理");
//        decodeUserNameAndPass(request);

        Map<String, String[]> map = request.getParameterMap();
        Object aa = request.getAttribute("param");
        String string = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        System.out.println(string);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("后处理");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("完成");
    }

    private void decodeUserNameAndPass(HttpServletRequest request) {
        String authrization = request.getHeader("Authorization");
        if(StringUtils.isEmpty(authrization)){
            System.out.println("authroization 为空");
        }else {
            String[] authArr = authrization.split(" ");
            String info = authArr.length>=2? authArr[1]:null;
            String infode = Arrays.toString(Base64.getDecoder().decode(info));
            System.out.println(infode);
        }
    }
}
