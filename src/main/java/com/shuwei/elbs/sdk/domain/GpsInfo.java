package com.shuwei.elbs.sdk.domain;

import java.io.Serializable;
import java.util.List;

/**
 * gps信息
 */
public class GpsInfo implements Serializable {
    /**
     * 卫星信息
     */
    private List<SatelliteInfo> satelliteInfo;
    /**
     * 获取是网络定位、GPS定位还是被动定位
     */
    private String mProvider;
    /**
     * 获取此位置的估计精确度
     */
    private Double mHorizontalAccuracyMeters;
    /**
     * 海拔高度
     */
    private Double mAltitude;
    /**
     * 方向度数（0,360）表示正北偏东多少度（0->北，90->东，180->南，270->西）
     */
    private Double mBearing;
    /**
     * 获取时间（单位：纳秒）
     */
    private Long mElapsedRealtimeNanos;
    /**
     * 自传速度（单位：m/s）
     */
    private Double mSpeed;
    /**
     * 扫描到的卫星总数
     */
    private Integer mSatelliteCount;
    /**
     * 采集时间戳
     */
    private Long timestamp;

    public String gpsMsnrInfo(){
        if (satelliteInfo == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (SatelliteInfo satelliteInfo : this.satelliteInfo) {
            if (satelliteInfo != null){
                if (satelliteInfo.getmSnr() != null){
                    sb.append(satelliteInfo.getmSnr());
                    sb.append(";");
                }
            }
        }
        return sb.length() > 0 ? sb.toString():null;
    }


    public List<SatelliteInfo> getSatelliteInfo() {
        return satelliteInfo;
    }

    public void setSatelliteInfo(List<SatelliteInfo> satelliteInfo) {
        this.satelliteInfo = satelliteInfo;
    }

    public String getmProvider() { return mProvider; }

    public void setmProvider(String mProvider) { this.mProvider = mProvider; }

    public Double getmHorizontalAccuracyMeters() { return mHorizontalAccuracyMeters; }

    public void setmHorizontalAccuracyMeters(Double mHorizontalAccuracyMeters) {
        this.mHorizontalAccuracyMeters = mHorizontalAccuracyMeters;
    }

    public Double getmAltitude() {
        return mAltitude;
    }

    public void setmAltitude(Double mAltitude) {
        this.mAltitude = mAltitude;
    }

    public Double getmBearing() { return mBearing; }

    public void setmBearing(Double mBearing) { this.mBearing = mBearing; }

    public Long getmElapsedRealtimeNanos() {
        return mElapsedRealtimeNanos;
    }

    public void setmElapsedRealtimeNanos(Long mElapsedRealtimeNanos) {
        this.mElapsedRealtimeNanos = mElapsedRealtimeNanos;
    }

    public Double getmSpeed() { return mSpeed; }

    public void setmSpeed(Double mSpeed) { this.mSpeed = mSpeed; }

    public Integer getmSatelliteCount() {
        return mSatelliteCount;
    }

    public void setmSatelliteCount(Integer mSatelliteCount) {
        this.mSatelliteCount = mSatelliteCount;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "GpsInfo{" +
                "satelliteInfo=" + satelliteInfo +
                ", mProvider='" + mProvider + '\'' +
                ", mHorizontalAccuracyMeters=" + mHorizontalAccuracyMeters +
                ", mAltitude=" + mAltitude +
                ", mBearing=" + mBearing +
                ", mElapsedRealtimeNanos=" + mElapsedRealtimeNanos +
                ", mSpeed=" + mSpeed +
                ", mSatelliteCount=" + mSatelliteCount +
                ", timestamp=" + timestamp +
                '}';
    }
}
