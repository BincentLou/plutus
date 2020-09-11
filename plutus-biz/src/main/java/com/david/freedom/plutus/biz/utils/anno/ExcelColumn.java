package com.david.freedom.plutus.biz.utils.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version $Id: null.java, v 1.0 2020/9/4 11:12 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description: excel的字段注解
 * @since 1.0
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelColumn {

    String value() default "";

    int col() default 0;

}
