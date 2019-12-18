package com.shuwei.elbs.sdk.constant;

/**
 * 坐标系枚举定义
 */
public enum CoordinateSystemEnum {
    /**
     * 不确定
     */
    UNKNOWN("UNKNOWN"),
    /**
     * BD09(百度)
     */
    BD09("BD09"),
    /**
     * GCJ02(高德、火星)
     */
    GCJ02("GCJ02"),
    /**
     * WGS84(谷歌、地球)
     */
    WGS84( "WGS84")
    ;

    private String name;

    public String getName() {
        return name;
    }

    CoordinateSystemEnum(String name) {
        this.name = name;
    }
}
