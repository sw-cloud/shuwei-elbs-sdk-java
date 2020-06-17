package com.shuwei.elbs.sdk.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**
 * Sha1加密工具类
 */
public final class Sha1Util {

    private final static Logger logger = LoggerFactory.getLogger(Sha1Util.class);

    private Sha1Util(){}

    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    /**
     * 加密
     * @param str 加密字符串
     * @return
     */
    public static String encrypt(String str) {
        if (str == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            logger.warn("shuwei Sha1Util encrypt error:", e);
            return "";
        }
    }


    /**
     * 规范密文格式
     * @param bytes 密文
     * @return
     */
    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString().toLowerCase();
    }
}
