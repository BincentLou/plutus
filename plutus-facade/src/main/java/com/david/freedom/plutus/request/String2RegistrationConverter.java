package com.david.freedom.plutus.request;

import com.david.freedom.plutus.stats.RegistrationStatusEnum;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
/**
 * @version $Id: String2RegistrationConverter.java.java, v 1.0 2020/9/9 9:36 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class String2RegistrationConverter implements Converter<String, RegistrationStatusEnum> {

    @Override
    public RegistrationStatusEnum convert(String value) {
        return RegistrationStatusEnum.localByDesc(value);
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return typeFactory.constructType(String.class);
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return typeFactory.constructType(RegistrationStatusEnum.class);
    }
}
