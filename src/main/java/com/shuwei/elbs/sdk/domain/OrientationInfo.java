package com.shuwei.elbs.sdk.domain;

import java.io.Serializable;

/**
 * 移动设备的姿态方向信息
 */
public class OrientationInfo implements Serializable {
    /**
     * 俯仰角，绕X轴产生的角
     */
    private Double pitch;
    /**
     * 翻转角，绕y轴产生的角
     */
    private Double roll;
    /**
     * 方向角，绕Z轴产生的角
     */
    private Double azimuth;
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

    public Double getPitch() {
        return pitch;
    }

    public void setPitch(Double pitch) {
        this.pitch = pitch;
    }

    public Double getRoll() {
        return roll;
    }

    public void setRoll(Double roll) {
        this.roll = roll;
    }

    public Double getAzimuth() { return azimuth; }

    public void setAzimuth(Double azimuth) {
        this.azimuth = azimuth;
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
        return "OrientationInfo{" +
                "pitch=" + pitch +
                ", roll=" + roll +
                ", azimuth=" + azimuth +
                ", sensorName=" + sensorName +
                ", sensorVendor=" + sensorVendor +
                ", sensorVersion='" + sensorVersion + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
