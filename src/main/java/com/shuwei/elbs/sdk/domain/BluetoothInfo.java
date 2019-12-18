package com.shuwei.elbs.sdk.domain;

import java.io.Serializable;

/**
 * 蓝牙信息
 */
public class BluetoothInfo implements Serializable {
    /**
     * 设备名称
     */
    private String name;
    /**
     * MAC 地址，去除冒号分隔符保持小写
     */
    private String mac;
    /**
     * 信号强度（dBm）
     */
    private Integer rssi;
    /**
     * 设备 UUID
     */
    private String ibeaconUUID;
    /**
     * 设备 MajorId
     */
    private Integer ibeaconMajorId;
    /**
     * 设备 MinorId
     */
    private Integer ibeaconMinorId;
    /**
     * 采集时间戳
     */
    private Long timestamp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Integer getRssi() {
        return rssi;
    }

    public void setRssi(Integer rssi) {
        this.rssi = rssi;
    }

    public String getIbeaconUUID() {
        return ibeaconUUID;
    }

    public void setIbeaconUUID(String ibeaconUUID) {
        this.ibeaconUUID = ibeaconUUID;
    }

    public Integer getIbeaconMajorId() {
        return ibeaconMajorId;
    }

    public void setIbeaconMajorId(Integer ibeaconMajorId) {
        this.ibeaconMajorId = ibeaconMajorId;
    }

    public Integer getIbeaconMinorId() {
        return ibeaconMinorId;
    }

    public void setIbeaconMinorId(Integer ibeaconMinorId) {
        this.ibeaconMinorId = ibeaconMinorId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "BluetoothInfo{" +
                "name='" + name + '\'' +
                ", mac='" + mac + '\'' +
                ", rssi=" + rssi +
                ", ibeaconUUID='" + ibeaconUUID + '\'' +
                ", ibeaconMajorId=" + ibeaconMajorId +
                ", ibeaconMinorId=" + ibeaconMinorId +
                ", timestamp=" + timestamp +
                '}';
    }
}
