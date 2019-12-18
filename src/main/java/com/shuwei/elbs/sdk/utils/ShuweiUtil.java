package com.shuwei.elbs.sdk.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 工具类
 */
public final class ShuweiUtil {

    private ShuweiUtil(){}

    /**
     * 是否匹配指定格式
     * @param pattern
     * @param str
     * @return true:匹配
     */
    public static boolean matchStr(Pattern pattern, String str){
        if(pattern == null || isEmpty(str)){
            return false;
        }
        return pattern.matcher(str).find();
    }

    /**
     * 转成json字符串
     * @param t
     * @param <T>
     * @return
     */
    public  static <T> String toJsonStr(T t) {
        if(t == null){
            return "";
        }
        return new Gson().toJson(t);
    }

    /**
     * 转成json对象
     * @param data
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T toJsonObj(String data, Class<T> type) throws JsonSyntaxException {
        if(data==null || "".equals(data)){
            return null;
        }

        return new Gson().fromJson(data, type);
    }

    /**
     * 签名计算
     * @param params
     * @param appKey
     * @return
     */
    public static String getSign(Map<String, Object> params, String appKey) {
        Object[] keys = params.keySet().toArray();
        Arrays.sort(keys);
        String k;
        Object v;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keys.length; i++) {
            k = (String) keys[i];
            if (k.equals("sign") || k.equals("s")) {
                continue;
            }
            v = params.get(k);

            if (v == null || "".equals(v)) {
                continue;
            }

            sb.append(v).append("#");
        }
        sb.append(appKey);
        return Sha1Util.encrypt(sb.toString());
    }

    /**
     * 字符串为空判断
     * @param str
     * @return true-为空
     */
    public static boolean isEmpty(String str){
        return str==null || "".equals(str.trim());
    }

    /**
     * 集合为空判断
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * map为空判断
     * @param map
     * @return
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }
}
