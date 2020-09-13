package com.david.freedom.plutus.mvc.interceptor;

import com.david.freedom.plutus.decode.Base64DecodeUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        decodeUserNameAndPass(request);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("后处理");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // ex 是否为null
        System.out.println("完成");
        System.out.println(response.getStatus());
    }

    private void decodeUserNameAndPass(HttpServletRequest request) {
        String authrization = request.getHeader("Authorization");
        Base64DecodeUtils.UserAndPassword userInfo = Base64DecodeUtils.decodeUserAndPassword(authrization);
    }
}
