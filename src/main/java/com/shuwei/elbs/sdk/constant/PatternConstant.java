package com.shuwei.elbs.sdk.constant;

import java.util.regex.Pattern;

/**
 * 匹配模板
 */
public final class PatternConstant {
    public static final Pattern PATTERN_APPID = Pattern.compile("^[a-f0-9]{12}$");
    public static final Pattern PATTERN_APPKEY = Pattern.compile("^[a-f0-9]{8}(-[a-f0-9]{4}){3}-[a-f0-9]{12}$");
}
