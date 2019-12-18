package com.shuwei.elbs.sdk.domain;

import com.shuwei.elbs.sdk.constant.CoordinateSystemEnum;

/**
 * 坐标信息API请求参数
 */
public class CoordinateInfo {
    /**
     * 坐标系
     * @see CoordinateSystemEnum
     */
    private String coordinateSystem;
    /**
     *  经度
     */
    private Double longitude;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 采集时间戳
     */
    private Long timestamp;

    public String getCoordinateSystem() {
        return coordinateSystem;
    }

    public void setCoordinateSystem(String coordinateSystem) {
        this.coordinateSystem = coordinateSystem;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
