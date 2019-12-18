package com.shuwei.elbs.sdk;

import com.shuwei.elbs.sdk.constant.PatternConstant;
import com.shuwei.elbs.sdk.utils.ShuweiUtil;

/**
 * @Author: will
 * @Description:
 * @Date: Created in 2019/6/18 10:08
 */
public class ELBSProfile {
    private String appId;
    private String appKey;
    private String url;

    public ELBSProfile(String appId, String appKey, String url) {
        this.appId = appId;
        this.appKey = appKey;
        this.url = url;
    }

    public ELBSProfile() {
    }

    public boolean lackNeedParams(){
        return  ShuweiUtil.isEmpty(appId) ||
                ShuweiUtil.isEmpty(appKey) ||
                ShuweiUtil.isEmpty(url);
    }

    public boolean formatCheck(){
        return ShuweiUtil.matchStr(PatternConstant.PATTERN_APPID, appId)
                && ShuweiUtil.matchStr(PatternConstant.PATTERN_APPKEY, appKey);
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
