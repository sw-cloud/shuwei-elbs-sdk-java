package com.shuwei.elbs.sdk.domain;

/**
 * 卫星信息
 */
public class SatelliteInfo {
    /**
     * GPS引擎是否有卫星星历(有则返回true)
     */
    private Boolean mHasEphemeris;
    /**
     * GPS引擎是否有近似轨道信息(有则返回true)
     */
    private Boolean mHasAlmanac;
    /**
     * 卫星是否被GPS引擎用于计算最近位置(是则返回true)
     */
    private Boolean mUsedInFix;
    /**
     * 伪随机噪声码
     */
    private Integer mPrn;
    /**
     * 卫星的信噪比
     */
    private Double mSnr;
    /**
     * 卫星的高度角
     */
    private Double mElevation;
    /**
     * 卫星的方位角
     */
    private Double mAzimuth;
    /**
     * 所跟踪信号的载波频率
     */
    private Double mCarrierFrequencyHz;

    public Boolean getmHasEphemeris() {
        return mHasEphemeris;
    }

    public void setmHasEphemeris(Boolean mHasEphemeris) {
        this.mHasEphemeris = mHasEphemeris;
    }

    public Boolean getmHasAlmanac() {
        return mHasAlmanac;
    }

    public void setmHasAlmanac(Boolean mHasAlmanac) {
        this.mHasAlmanac = mHasAlmanac;
    }

    public Boolean getmUsedInFix() {
        return mUsedInFix;
    }

    public void setmUsedInFix(Boolean mUsedInFix) {
        this.mUsedInFix = mUsedInFix;
    }

    public Integer getmPrn() {
        return mPrn;
    }

    public void setmPrn(Integer mPrn) {
        this.mPrn = mPrn;
    }

    public Double getmSnr() { return mSnr; }

    public void setmSnr(Double mSnr) { this.mSnr = mSnr; }

    public Double getmElevation() { return mElevation; }

    public void setmElevation(Double mElevation) { this.mElevation = mElevation; }

    public Double getmAzimuth() { return mAzimuth; }

    public void setmAzimuth(Double mAzimuth) { this.mAzimuth = mAzimuth; }

    public Double getmCarrierFrequencyHz() {
        return mCarrierFrequencyHz;
    }

    public void setmCarrierFrequencyHz(Double mCarrierFrequencyHz) {
        this.mCarrierFrequencyHz = mCarrierFrequencyHz;
    }

    @Override
    public String toString() {
        return "SatelliteInfo{" +
                "mHasEphemeris=" + mHasEphemeris +
                ", mHasAlmanac=" + mHasAlmanac +
                ", mUsedInFix=" + mUsedInFix +
                ", mPrn=" + mPrn +
                ", mSnr=" + mSnr +
                ", mElevation=" + mElevation +
                ", mAzimuth=" + mAzimuth +
                ", mCarrierFrequencyHz=" + mCarrierFrequencyHz +
                '}';
    }
}
