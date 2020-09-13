package com.david.freedom.plutus.decode;

import org.springframework.util.StringUtils;

import java.util.Base64;

/**
 * @version $Id: null.java, v 1.0 2020/9/12 12:56 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class Base64DecodeUtils {

    public static UserAndPassword decodeUserAndPassword(String authrization){
        if(StringUtils.isEmpty(authrization)){
            return null;
        }else {
            String[] authArr = authrization.split(" ");
            String info = authArr.length>=2? authArr[1]:null;
            String infode = new String(Base64.getDecoder().decode(info));
            String[] userInfo = infode.split(":");
            return new UserAndPassword(userInfo[0],userInfo[1]);
        }
    }

    public static class UserAndPassword{
        private String userName;

        private String password;

        public UserAndPassword(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public UserAndPassword setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public String getPassword() {
            return password;
        }

        public UserAndPassword setPassword(String password) {
            this.password = password;
            return this;
        }

        @Override
        public String toString() {
            return "UserAndPassword{" +
                    "userName='" + userName + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}
