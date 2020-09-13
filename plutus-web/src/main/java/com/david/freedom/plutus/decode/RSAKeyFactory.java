package com.david.freedom.plutus.decode;

import org.apache.commons.codec.binary.Base64;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @version $Id: null.java, v 1.0 2020/9/13 11:16 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description 公私钥生成器
 * @since 1.0
 **/
public class RSAKeyFactory {


    public static KeyPairObject getKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-1024位
        // RSA密钥长度必须是64的倍数，在512~65536之间。默认是1024
        keyPairGen.initialize(2048,new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
        // 得到私钥字符串
        String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
        return new KeyPairObject(publicKeyString,privateKeyString);
    }

    public static class KeyPairObject{

        private String publicKey;

        private String privateKey;

        public KeyPairObject(String publicKey, String privateKey) {
            this.publicKey = publicKey;
            this.privateKey = privateKey;
        }

        @Override
        public String toString() {
            return "KeyPair{" +
                    "publicKey='" + publicKey + '\'' +
                    ", privateKey='" + privateKey + '\'' +
                    '}';
        }

        public String getPublicKey() {
            return publicKey;
        }

        public KeyPairObject setPublicKey(String publicKey) {
            this.publicKey = publicKey;
            return this;
        }

        public String getPrivateKey() {
            return privateKey;
        }

        public KeyPairObject setPrivateKey(String privateKey) {
            this.privateKey = privateKey;
            return this;
        }
    }
}
