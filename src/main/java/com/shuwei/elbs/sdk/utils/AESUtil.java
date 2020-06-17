package com.shuwei.elbs.sdk.utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Security;
import java.util.Base64;

/**
 * AES加密工具类
 */
public final class AESUtil {
    /**
     * 初始化标记
     */
    private static boolean initialized = false;

    /**
     * aes加密
     * @param sSrc 待加密的原始字符串
     * @param sKey
     * @param ivP
     * @return 加密后的base64字符串
     * @throws Exception
     */
    public static String encrypt(String sSrc, String sKey, String ivP) throws Exception {
        return Base64.getEncoder().encodeToString(encrypt128(sSrc, sKey, ivP));
    }

    /**
     * aes解密
     * @param sSrc base64后的加密字符串
     * @param sKey
     * @param ivP
     * @return 解密后的字符串
     * @throws Exception
     */
    public static String decrypt(String sSrc, String sKey, String ivP) throws Exception {
        return decrypt128(Base64.getDecoder().decode(sSrc.getBytes(StandardCharsets.UTF_8)), sKey, ivP);
    }

    /**
     * aes加密
     * @param sSrc 待加密的原始字符串
     * @param sKey
     * @param ivP
     * @return 加密后的字节数组
     * @throws Exception
     */
    private static byte[] encrypt128(String sSrc, String sKey, String ivP) throws Exception {
        initialize();
        // 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        IvParameterSpec iv = new IvParameterSpec(ivP.getBytes(StandardCharsets.UTF_8));
        byte[] enCodeFormat = sKey.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec skeySpec = new SecretKeySpec(enCodeFormat , "AES");
        // "算法/模式/补码方式"
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        return cipher.doFinal(sSrc.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * aes解密
     * @param content 加密后的字节数组
     * @param sKey
     * @param ivP
     * @return 解密后的字符串
     * @throws Exception
     */
    private static String decrypt128(byte[] content, String sKey, String ivP) throws Exception {
        initialize();
        IvParameterSpec iv = new IvParameterSpec(ivP.getBytes(StandardCharsets.UTF_8));
        byte[] enCodeFormat = sKey.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec skeySpec = new SecretKeySpec(enCodeFormat , "AES");
        // "算法/模式/补码方式"
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] result = cipher.doFinal(content);
        return new String(result);
    }

    /**
     * BouncyCastle作为安全提供，防止我们加密解密时候因为jdk内置的不支持改模式运行报错
     */
    private static void initialize() {
        if (initialized) {
            return;
        }
        Security.addProvider(new BouncyCastleProvider());
        initialized = true;
    }

    private AESUtil(){}
}
