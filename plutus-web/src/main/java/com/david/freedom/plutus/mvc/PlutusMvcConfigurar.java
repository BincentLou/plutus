package com.david.freedom.plutus.mvc;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.david.freedom.plutus.mvc.filter.DecodeAndHttpServletRequestReplacedFilter;
import com.david.freedom.plutus.mvc.interceptor.DecodeInterceptor;

/**
 * @version $Id: null.java, v 1.0 2020/9/11 3:41 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
@Configuration
public class PlutusMvcConfigurar implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DecodeInterceptor());
    }


    @Bean
    public FilterRegistrationBean requestReplaceWapper(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new DecodeAndHttpServletRequestReplacedFilter());
        registration.addUrlPatterns("/cop/paph/dispatcher/*");
        registration.setName("httpServletRequestReplacedFilter");
        registration.setOrder(1);
        return registration;

    }

}
