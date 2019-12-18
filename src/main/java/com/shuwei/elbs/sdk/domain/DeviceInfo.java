package com.shuwei.elbs.sdk.domain;

import java.io.Serializable;

/**
 * 设备信息
 */
public class DeviceInfo implements Serializable {
    /**
     * Android 系统的设备号
     */
    private String imei;
    /**
     * 仅iOS6.0以上系统的IDFA,如4CFD11F0-09D0-4BF3-91CED50600BD0E64
     */
    private String idfa;
    /**
     * 用户终端的AndroidID,如9774d56d682e549c
     */
    private String andid;
    /**
     * 设 备 品 牌 和 型 号 ， 如 honor v8 、Sumsang S6
     */
    private String device;
    /**
     * 操作系统版本，如 iPhone 8.1.2 的参数填写 8.1.2
     */
    private String osv;
    /**
     * 运营商： 0：unknown 1：CMCC 2：CUCC 3：CTCC
     */
    private String carrier;
    /**
     * 国际移动用户识别码
     */
    private String imsi;
    /**
     * 系统romInfo
     */
    private String romInfo;
    /**
     * 屏幕宽度
     */
    private Float width;
    /**
     * 屏幕高度
     */
    private Float height;

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String getAndid() {
        return andid;
    }

    public void setAndid(String andid) {
        this.andid = andid;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getOsv() {
        return osv;
    }

    public void setOsv(String osv) {
        this.osv = osv;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getRomInfo() {
        return romInfo;
    }

    public void setRomInfo(String romInfo) {
        this.romInfo = romInfo;
    }

    @Override
    public String toString() {
        return "DeviceInfo{" +
                "imei='" + imei + '\'' +
                ", idfa='" + idfa + '\'' +
                ", andid='" + andid + '\'' +
                ", device='" + device + '\'' +
                ", osv='" + osv + '\'' +
                ", carrier='" + carrier + '\'' +
                ", imsi='" + imsi + '\'' +
                ", romInfo='" + romInfo + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
