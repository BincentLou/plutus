package com.david.freedom.plutus.common.states;

/**
 * @version $Id: null.java, v 1.0 2020/9/8 10:35 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public interface BaseEnum {

    String getDesc();

    default BaseEnum getByDesc(String desc){
        return null;
    }
}
