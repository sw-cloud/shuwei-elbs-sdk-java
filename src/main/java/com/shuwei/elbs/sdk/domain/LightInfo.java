package com.shuwei.elbs.sdk.domain;

import java.io.Serializable;

/**
 * 光强信息
 */
public class LightInfo implements Serializable {
    /**
     * 光强信息
     */
    private Double lux;
    /**
     * 传感器名称
     */
    private String sensorName;
    /**
     * 传感器供应商
     */
    private String sensorVendor;
    /**
     * 传感器版本
     */
    private String sensorVersion;
    /**
     * 采集时间戳
     */
    private Long timestamp;

    public Double getLux() {
        return lux;
    }

    public void setLux(Double lux) {
        this.lux = lux;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getSensorVendor() {
        return sensorVendor;
    }

    public void setSensorVendor(String sensorVendor) {
        this.sensorVendor = sensorVendor;
    }

    public String getSensorVersion() {
        return sensorVersion;
    }

    public void setSensorVersion(String sensorVersion) {
        this.sensorVersion = sensorVersion;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "LightInfo{" +
                "lux=" + lux +
                ", sensorName='" + sensorName +
                ", sensorVendor='" + sensorVendor +
                ", sensorVersion='" + sensorVersion + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
