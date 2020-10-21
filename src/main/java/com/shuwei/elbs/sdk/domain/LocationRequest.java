package com.shuwei.elbs.sdk.domain;

import com.shuwei.elbs.sdk.utils.ShuweiUtil;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定位请求数据
 */
public class LocationRequest extends ELBSRequest {
    /**
     * appId
     */
    private String appId;
    /**
     * ssid是否做base64加密：0-不加密,1-加密
     */
    private Integer ssidEncode;
    /**
     * 签名
     */
    private String sign;

    public String authorization(){
        return String.format("t=%d;a=%s", getTimestamp(), this.appId);
    }

    /**
     * 获取签名
     * @param appKey
     */
    private void handleSign(String appKey){
        this.sign = ShuweiUtil.getSign(signParams(), appKey);
    }

    private void handleSignals(ELBSRequest requestData){
        List<WifiItem> signals = requestData.getSignals();
        if(signals == null || signals.isEmpty()){
            return;
        }
        for(WifiItem wifiItem : signals){
            if(wifiItem == null || ShuweiUtil.isEmpty(wifiItem.getSsid())){
                continue;
            }
            wifiItem.setSsid(Base64.getEncoder().encodeToString(wifiItem.getSsid().getBytes(StandardCharsets.UTF_8)));
        }
        setSignals(signals);
        this.ssidEncode = 1;
    }

    /**
     * 参与签名的参数
     * @return
     */
    private Map<String, Object> signParams(){
        Map<String, Object> params = new HashMap<>();
        params.put("timestamp", getTimestamp());
        params.put("oid", getOid());
        params.put("oidType", getOidType());
        params.put("networkMode", getNetworkMode());
        params.put("appId", appId);
        params.put("mac", getMac());
        params.put("macType", getMacType());
        params.put("ssidEncode", ssidEncode);
        params.put("osType", getOsType());
        params.put("appChannel", getAppChannel());
        params.put("passthrough", getPassthrough());
        params.put("ext", getExt());
        return params;
    }

    public static LocationRequest newInstanceByRequestData(ELBSRequest requestData, String appId, String appKey){
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setAppChannel(requestData.getAppChannel());
        locationRequest.setAppId(appId);
        locationRequest.setExt(requestData.getExt());
        locationRequest.setAppInfo(requestData.getAppInfo());
        locationRequest.setBaseStationList(requestData.getBaseStationList());
        locationRequest.setBluetoothInfo(requestData.getBluetoothInfo());
        locationRequest.setDeviceInfo(requestData.getDeviceInfo());
        locationRequest.setGpsInfo(requestData.getGpsInfo());
        locationRequest.setLightInfo(requestData.getLightInfo());
        locationRequest.setMac(requestData.getMac());
        locationRequest.setMacType(requestData.getMacType());
        locationRequest.setMagneticInfo(requestData.getMagneticInfo());
        locationRequest.setNetworkMode(requestData.getNetworkMode());
        locationRequest.setOid(requestData.getOid());
        locationRequest.setOidType(requestData.getOidType());
        locationRequest.setOrientationInfo(requestData.getOrientationInfo());
        locationRequest.setOsType(requestData.getOsType());
        locationRequest.setPassthrough(requestData.getPassthrough());
        locationRequest.setTimestamp(requestData.getTimestamp());
        locationRequest.handleSignals(requestData);
        locationRequest.handleSign(appKey);
        return locationRequest;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Integer getSsidEncode() {
        return ssidEncode;
    }

    public void setSsidEncode(Integer ssidEncode) {
        this.ssidEncode = ssidEncode;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
