package com.david.freedom.plutus.decode;

/**
 * @version $Id: null.java, v 1.0 2020/9/12 1:23 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA2048加密工具类
 *
 * @author CHENQINGYANG039
 *
 */
public class RSA2048Util {

    private static final Logger LOGGER = LoggerFactory.getLogger(RSA2048Util.class);

    /**
     * RSA密钥长度必须是64的倍数，在512~65536之间。默认是1024
     */
    private static final int KEY_SIZE = 2048;

    /**
     * 使用工钥加密
     *
     * @param content 待加密内容
     * @param publicKey 公钥
     * @return 经过 base64 编码后的字符串
     */
    public static String rsaEncrypt(String content, String publicKey) {
        return encipher(content, publicKey, KEY_SIZE / 8 - 11);
    }

    /**
     * 使用私钥解密
     *
     * @param content 待解密内容
     * @param privateKey 私钥
     * @return
     */
    public static String rsaDecipher(String content, String privateKey) {
        return decipher(content, privateKey, KEY_SIZE / 8);
    }

    /**
     * 使用公钥加密（分段加密）
     *
     * @param content         待加密内容
     * @param publicKey 公钥 base64 编码
     * @param segmentSize     分段大小,一般小于 keySize/8（段小于等于0时，将不使用分段加密）
     * @return 经过 base64 编码后的字符串
     */
    private static String encipher(String content, String publicKey, int segmentSize) {
        try {
            RSAPublicKey rsaPublicKey = getPublicKey(publicKey);
            return encipher(content, rsaPublicKey, segmentSize);
        } catch (Exception e) {
            LOGGER.error("RSA2048异常：{}", e);
            return null;
        }
    }

    /**
     * 获取公钥对象
     *
     * @param publicKey
     * @return
     * @throws Exception
     */
    private static RSAPublicKey getPublicKey(String publicKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec publicpkcs8KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyFactory.generatePublic(publicpkcs8KeySpec);
        return rsaPublicKey;
    }

    /**
     * 分段加密
     *
     * @param ciphertext  密文
     * @param rsaPublicKey         加密秘钥
     * @param segmentSize 分段大小，<=0 不分段
     * @return
     */
    private static String encipher(String ciphertext, Key rsaPublicKey, int segmentSize) {
        try {
            // 用公钥加密
            byte[] srcBytes = ciphertext.getBytes("UTF-8");
            // Cipher负责完成加密或解密工作，基于RSA
            Cipher cipher = Cipher.getInstance("RSA");
            // 根据公钥，对Cipher对象进行初始化
            cipher.init(Cipher.ENCRYPT_MODE, rsaPublicKey);
            byte[] resultBytes = null;
            if (segmentSize > 0) {
                //分段加密
                resultBytes = cipherDoFinal(cipher, srcBytes, segmentSize);
            } else {
                resultBytes = cipher.doFinal(srcBytes);
            }
            String base64Str = Base64.encodeBase64String(resultBytes);
            return base64Str;
        } catch (Exception e) {
            LOGGER.error("RSA2048异常：{}", e);
            return null;
        }
    }

    /**
     * 分段大小
     *
     * @param cipher
     * @param srcBytes
     * @param segmentSize
     * @return
     * @throws Exception
     */
    private static byte[] cipherDoFinal(Cipher cipher, byte[] srcBytes, int segmentSize) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int inputLen = srcBytes.length;
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > segmentSize) {
                cache = cipher.doFinal(srcBytes, offSet, segmentSize);
            } else {
                cache = cipher.doFinal(srcBytes, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * segmentSize;
        }
        byte[] data = out.toByteArray();
        out.close();
        return data;
    }

    /**
     * 使用私钥解密（分段解密）
     *
     * @param content    待解密内容
     * @param privateKey 私钥
     * @return
     * @segmentSize 分段大小
     */
    private static String decipher(String content, String privateKey, int segmentSize) {
        try {
            RSAPrivateKey rsaPrivateKey = getPrivateKey(privateKey);
            return decipher(content, rsaPrivateKey, segmentSize);
        } catch (Exception e) {
            LOGGER.error("RSA2048异常：{}", e);
            return null;
        }
    }

    /**
     * 获取私钥对象
     *
     * @param privateKey
     * @return
     * @throws Exception
     */
    private static RSAPrivateKey getPrivateKey(String privateKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec privatekcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyFactory.generatePrivate(privatekcs8KeySpec);
        return rsaPrivateKey;
    }

    /**
     * 分段解密
     *
     * @param content 密文
     * @param rsaPrivateKey           解密秘钥
     * @param segmentSize   分段大小（小于等于0不分段）
     * @return
     */
    private static String decipher(String content, Key rsaPrivateKey, int segmentSize) {
        try {
            // 用私钥解密
            byte[] srcBytes = Base64.decodeBase64(content.getBytes("UTF-8"));
            // Cipher负责完成加密或解密工作，基于RSA
            Cipher deCipher = Cipher.getInstance("RSA");
            // 根据私钥，对Cipher对象进行初始化
            deCipher.init(Cipher.DECRYPT_MODE, rsaPrivateKey);
            byte[] decBytes = null;
            if (segmentSize > 0) {
                //分段解密
                decBytes = cipherDoFinal(deCipher, srcBytes, segmentSize);
            } else {
                decBytes = deCipher.doFinal(srcBytes);
            }
            String decrytStr = new String(decBytes, "UTF-8");
            return decrytStr;
        } catch (Exception e) {
            LOGGER.error("RSA2048异常：{}", e);
            return null;
        }
    }
}

