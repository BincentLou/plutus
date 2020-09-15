package com.david.freedom.plutus.common.anno;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


/**
 * @version $Id: null.java, v 1.0 2020/9/14 9:46 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:平安普惠调用保险的注解切面处理 @see {@link PAPHCallApi}
 * @since 1.0
 **/
@Aspect
@Component
public class PAPHCallApiAspect {


    @Pointcut(value = "@annotation(com.david.freedom.plutus.common.anno.PAPHCallApi)")
    public void pointCut(){

    }

    @Around(value = "pointCut()")
    public Object aroud(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        PAPHCallApi paphCallApi = method.getAnnotation(PAPHCallApi.class);
        System.out.println(paphCallApi.serverModule());
        System.out.println(joinPoint.getArgs()[0]);
        return joinPoint.proceed();
    }

}
