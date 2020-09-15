package com.david.freedom.plutus.common.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version $Id: null.java, v 1.0 2020/9/14 9:18 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:平安普惠调用保险的注解
 * @since 1.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface PAPHCallApi {

    /**
     */
    String serverModule() default "000";

    /**
     */
    String serviceScene() default "10";

    /**
     * 业务描述
     */
    String description() default "";


}
