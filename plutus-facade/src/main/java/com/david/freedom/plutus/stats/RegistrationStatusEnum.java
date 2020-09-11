package com.david.freedom.plutus.stats;

import com.david.freedom.plutus.common.states.BaseEnum;
import com.david.freedom.plutus.request.String2RegistrationConverter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @version $Id: null.java, v 1.0 2020/9/4 10:30 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:登记信息状态
 * @since 1.0
 **/

@JsonDeserialize(converter = String2RegistrationConverter.class)
public enum RegistrationStatusEnum implements BaseEnum {
    NORMAL("1","正常"),

    BACK_UP("2","已备份"),

    DELETED("3","已删除")
    ;


    private String key;

    private String desc;

    RegistrationStatusEnum(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public static RegistrationStatusEnum localByKey(String key) {

        for (RegistrationStatusEnum value : values()) {

            if(value.getKey().equals(key)){
                return value;
            }
        }
        return null;
    }
    public static RegistrationStatusEnum localByDesc(String desc) {

        for (RegistrationStatusEnum value : values()) {

            if(value.getDesc().equals(desc)){
                return value;
            }
        }
        return null;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    public RegistrationStatusEnum setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
