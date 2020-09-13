package com.david.freedom.plutus.request;

import java.io.Serializable;

/**
 * @version $Id: null.java, v 1.0 2020/9/13 10:51 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class ThridPathRequest implements Serializable {

    private static final long serialVersionUID = -4696639017056945190L;

    private String userName;


    private String address;

    @Override
    public String toString() {
        return "ThridPathRequest{" +
                "userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public ThridPathRequest setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ThridPathRequest setAddress(String address) {
        this.address = address;
        return this;
    }
}
