package com.shuwei.elbs.sdk.domain;

import java.io.Serializable;

/**
 * 移动设备所在位置的磁场信息
 */
public class MagneticInfo implements Serializable {
    /**
     * X轴方向的磁感应强度
     */
    private Double magX;
    /**
     * Y轴方向的磁感应强度
     */
    private Double magY;
    /**
     * Z轴方向的磁感应强度
     */
    private Double magZ;
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
    public Double getMagX() { return magX; }

    public void setMagX(Double magX) { this.magX = magX; }

    public Double getMagY() { return magY; }

    public void setMagY(Double magY) { this.magY = magY; }

    public Double getMagZ() { return magZ; }

    public void setMagZ(Double magZ) { this.magZ = magZ; }

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
        return "MagneticInfo{" +
                "magX=" + magX +
                ", magY=" + magY +
                ", magZ=" + magZ +
                ", sensorName=" + sensorName +
                ", sensorVendor=" + sensorVendor +
                ", sensorVersion='" + sensorVersion + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
