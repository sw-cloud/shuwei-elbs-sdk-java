package com.shuwei.elbs.sdk.domain;


import com.shuwei.elbs.sdk.annotation.NecessaryField;
import com.shuwei.elbs.sdk.utils.ShuweiUtil;

import java.io.Serializable;
import java.util.List;

/**
 * 请求数据
 */
public class ELBSRequest implements Serializable{
    /**
     * 时间戳
     */
    @NecessaryField
    private Long timestamp;
    /**
     * 手机标识
     */
    @NecessaryField
    private String oid;
    /**
     * 手机标识类型 1-IMEI号 4-iosIDFA
     */
    @NecessaryField
    private String oidType;
    /**
     * 联网方式 1-wifi 2-2G 3-3G 4-4G
     */
    @NecessaryField
    private String networkMode;
    /**
     * wifi列表
     */
    @NecessaryField
    private List<WifiItem> signals;
    /**
     * 终端网卡的MAC地址
     */
    private String mac;
    /**
     * 终端网卡的MAC地址类型
     */
    private String macType;
    /**
     * 操作系统类型：0-不确定 1-Android 2-iOS
     */
    private Integer osType;
    /**
     * 应用流量来源的渠道 1-APP
     */
    private Integer appChannel;
    /**
     * 扩展参数
     */
    private String ext;
    /**
     * 透传信息,在响应时原样返回
     */
    private String passthrough;
    /**
     * 基站信息
     */
    private List<BaseStation> baseStationList;
    /**
     * 设备信息
     */
    private DeviceInfo deviceInfo;
    /**
     * 应用信息
     */
    private List<AppInfo> appInfo;
    /**
     * 蓝牙信息
     */
    private List<BluetoothInfo> bluetoothInfo;
    /**
     * 磁场信息
     */
    private MagneticInfo magneticInfo;
    /**
     * 姿态方向信息
     */
    private OrientationInfo orientationInfo;
    /**
     * 光强信息
     */
    private LightInfo lightInfo;
    /**
     * GPS信息
     */
    private GpsInfo gpsInfo;
    /**
     * 经纬度信息
     */
    private CoordinateInfo coordinateInfo;

    public boolean lackNeedParams(){
        return timestamp== null ||
                ShuweiUtil.isEmpty(oid) ||
                ShuweiUtil.isEmpty(oidType) ||
                ShuweiUtil.isEmpty(networkMode) ||
                (ShuweiUtil.isEmpty(signals) && ShuweiUtil.isEmpty(baseStationList));
    }

    public boolean formatCheck(){
        return String.valueOf(timestamp).length() == 13;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getPassthrough() {
        return passthrough;
    }

    public void setPassthrough(String passthrough) {
        this.passthrough = passthrough;
    }

    public Integer getOsType() {
        return osType;
    }

    public void setOsType(Integer osType) {
        this.osType = osType;
    }

    public Integer getAppChannel() {
        return appChannel;
    }

    public void setAppChannel(Integer appChannel) {
        this.appChannel = appChannel;
    }

    public String getMacType() {
        return macType;
    }

    public void setMacType(String macType) {
        this.macType = macType;
    }

    public List<BaseStation> getBaseStationList() {
        return baseStationList;
    }

    public void setBaseStationList(List<BaseStation> baseStationList) {
        this.baseStationList = baseStationList;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOidType() {
        return oidType;
    }

    public void setOidType(String oidType) {
        this.oidType = oidType;
    }

    public String getNetworkMode() {
        return networkMode;
    }

    public void setNetworkMode(String networkMode) {
        this.networkMode = networkMode;
    }

    public List<WifiItem> getSignals() {
        return signals;
    }

    public void setSignals(List<WifiItem> signals) {
        this.signals = signals;
    }

    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public List<AppInfo> getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(List<AppInfo> appInfo) {
        this.appInfo = appInfo;
    }

    public List<BluetoothInfo> getBluetoothInfo() {
        return bluetoothInfo;
    }

    public void setBluetoothInfo(List<BluetoothInfo> bluetoothInfo) {
        this.bluetoothInfo = bluetoothInfo;
    }

    public MagneticInfo getMagneticInfo() {
        return magneticInfo;
    }

    public void setMagneticInfo(MagneticInfo magneticInfo) {
        this.magneticInfo = magneticInfo;
    }

    public OrientationInfo getOrientationInfo() {
        return orientationInfo;
    }

    public void setOrientationInfo(OrientationInfo orientationInfo) {
        this.orientationInfo = orientationInfo;
    }

    public LightInfo getLightInfo() {
        return lightInfo;
    }

    public void setLightInfo(LightInfo lightInfo) {
        this.lightInfo = lightInfo;
    }

    public GpsInfo getGpsInfo() {
        return gpsInfo;
    }

    public void setGpsInfo(GpsInfo gpsInfo) {
        this.gpsInfo = gpsInfo;
    }

    public CoordinateInfo getCoordinateInfo() {
        return coordinateInfo;
    }

    public void setCoordinateInfo(CoordinateInfo coordinateInfo) {
        this.coordinateInfo = coordinateInfo;
    }

    @Override
    public String toString() {
        return "ELBSRequest{" +
                "timestamp=" + timestamp +
                ", mac='" + mac + '\'' +
                ", macType='" + macType + '\'' +
                ", oid='" + oid + '\'' +
                ", oidType='" + oidType + '\'' +
                ", networkMode='" + networkMode + '\'' +
                ", osType=" + osType +
                ", appChannel=" + appChannel +
                ", ext='" + ext + '\'' +
                ", passthrough='" + passthrough + '\'' +
                ", signals=" + signals +
                ", baseStationList=" + baseStationList +
                ", deviceInfo=" + deviceInfo +
                ", appInfo=" + appInfo +
                ", bluetoothInfo=" + bluetoothInfo +
                ", magneticInfo=" + magneticInfo +
                ", orientationInfo=" + orientationInfo +
                ", lightInfo=" + lightInfo +
                ", gpsInfo=" + gpsInfo +
                '}';
    }
}
