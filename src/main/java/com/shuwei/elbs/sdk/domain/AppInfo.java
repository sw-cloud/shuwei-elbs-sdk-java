package com.shuwei.elbs.sdk.domain;

import java.io.Serializable;

/**
 * 应用信息
 */
public class AppInfo implements Serializable {
    /**
     * 应用的 PackageName
     */
    private String applicationId;
    /**
     * 版本号
     */
    private Integer versionCode;
    /**
     * 版本名
     */
    private String versionName;
    /**
     * 首次安装时间 ms
     */
    private Long firstTime;
    /**
     * 最新更新时间 ms
     */
    private Long lastTime;
    /**
     * App 前台使用时长
     */
    private Long totalTime;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Long getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Long firstTime) {
        this.firstTime = firstTime;
    }

    public Long getLastTime() {
        return lastTime;
    }

    public void setLastTime(Long lastTime) {
        this.lastTime = lastTime;
    }

    public Long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Long totalTime) {
        this.totalTime = totalTime;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "applicationId='" + applicationId + '\'' +
                ", versionCode=" + versionCode +
                ", versionName='" + versionName + '\'' +
                ", firstTime=" + firstTime +
                ", lastTime=" + lastTime +
                ", totalTime=" + totalTime +
                '}';
    }
}
