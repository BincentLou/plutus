package com.david.freedom.plutus.request;

import com.david.freedom.plutus.common.request.BaseRequest;
import com.david.freedom.plutus.stats.RegistrationStatusEnum;

import javax.validation.constraints.NotNull;

/**
 * @version $Id: null.java, v 1.0 2020/9/3 8:32 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:登记信息入参
 * @since 1.0
 **/
public class AddRegistratioInfoRequest extends BaseRequest {


    private static final long serialVersionUID = 6720283990065508200L;

    /**
     * 姓名
     */
    @NotNull(message = "姓名不能为空")
    private String userName;

    /**
     * 电话好吗
     */
    @NotNull(message = "电话好吗不能为空")
    private String telephone;

    /**
     * 身份证
     */
    @NotNull(message = "身份证不能为空")
    private String cretNo;

    @NotNull(message = "注册类型不能为空")
//    @JsonDeserialize(converter = String2RegistrationConverter.class)
    private RegistrationStatusEnum registrationStatusEnum;

    public String getUserName() {
        return userName;
    }

    public AddRegistratioInfoRequest setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public AddRegistratioInfoRequest setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public String getCretNo() {
        return cretNo;
    }

    public AddRegistratioInfoRequest setCretNo(String cretNo) {
        this.cretNo = cretNo;
        return this;
    }

    public RegistrationStatusEnum getRegistrationStatusEnum() {
        return registrationStatusEnum;
    }

    public AddRegistratioInfoRequest setRegistrationStatusEnum(RegistrationStatusEnum registrationStatusEnum) {
        this.registrationStatusEnum = registrationStatusEnum;
        return this;
    }
}
