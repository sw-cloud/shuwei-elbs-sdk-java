package com.shuwei.elbs.sdk.domain;

import java.io.Serializable;

/**
 * wifi信号
 */
public class WifiItem implements Serializable {
    /**
     * ap的mac地址
     */
    private String bssid;
    /**
     * 信号强度
     */
    private Integer rssi;
    /**
     * 名称
     */
    private String ssid;
    /**
     * 是否为连接信号（1表示连接，默认为null）
     */
    private Integer connectState;
    /**
     * wifi采集的时间戳(ms)
     */
    private Long timestamp;

    public WifiItem() {
    }

    public WifiItem(String bssid, Integer rssi, String ssid, Long timestamp, Integer connectState) {
        this.bssid = bssid;
        this.rssi = rssi;
        this.ssid = ssid;
        this.connectState = connectState;
        this.timestamp = timestamp;
    }


    public Integer getConnectState() {
        return connectState;
    }

    public void setConnectState(Integer connectState) {
        this.connectState = connectState;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getBssid() {
        return bssid;
    }

    public void setBssid(String bssid) {
        this.bssid = bssid;
    }

    public Integer getRssi() {
        return rssi;
    }

    public void setRssi(Integer rssi) {
        this.rssi = rssi;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }
}
