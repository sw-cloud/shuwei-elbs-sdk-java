package com.shuwei.elbs.sdk.domain;

import java.io.Serializable;

/**
 * 基站信息
 */
public class BaseStation implements Serializable{
    /**
     * 所 属 网 络 0: 未 知 ,1:GSM,2:CDMA,3:WCDMA ,4:LTE
     */
    private Integer type;
    /**
     * 移动国家代码 (GSM,CDMA,WCDMA,LTE)
     */
    private Integer mcc;
    /**
     * 移动网络号码 (GSM,CDMA,WCDMA,LTE)
     */
    private Integer mnc;
    /**
     * 位置区域码 (GSM,WCDMA)
     */
    private Integer lac;
    /**
     * UMTS 小区身份(GSM,WCDMA)
     */
    private Integer cid;
    /**
     * 跟踪区域码 (LTE)
     */
    private Integer tac;
    /**
     * 小区标识(LTE)
     */
    private Integer ci;
    /**
     * 物理小区 id (LTE)
     */
    private Integer pci;
    /**
     * WCDMA 主扰码(WCDMA)
     */
    private Integer psc;
    /**
     * CDMA System ID (CDMA)
     */
    private Integer sid;
    /**
     * Network ID (CDMA)
     */
    private Integer nid;
    /**
     * Base Station ID (CDMA)
     */
    private Integer bid;
    /**
     * 1 毫瓦分贝数 (GSM,CDMA,WCDMA,LTE)
     */
    private Integer dBm;
    /**
     * Asu 信号单元(GSM,CDMA,WCDMA,LTE)
     */
    private Integer asuLevel;
    /**
     * 信号格(GSM,CDMA,WCDMA,LTE)
     */
    private Integer level;
    /**
     * 采集时间戳
     */
    private Long timestamp;
    /**
     * 是否已注册: 1-注册 null-未注册
     */
    private Integer register;   //是否为连接信号（1表示注册，默认为null）
    /**
     * 基站实例类型，区分到底是什么基站实例，也可以此来区分版本
     */
    private String baseStationType;
    /**
     * Android N 新增，绝对射频频道号
     * (LTE)
     */
    private Integer earfcn;
    /**
     * 小区带宽
     * (LTE)
     */
    private Integer bandWidth;
    /**
     * Android N 新增，绝对射频频道号
     * (GSM)
     */
    private Integer arfcn;
    /**
     * Android N 新增，基站识别码，物理小区id
     * (GSM)
     */
    private Integer bsic;
    /**
     * Android N 新增，绝对射频频道号
     * (WCDMA)
     */
    private Integer uarfcn;

    /**
     * 信号接收强度
     * (LTE)
     */
    private Integer rsrp;
    /**
     * 信号接收质量
     * (LTE)
     */
    private Integer rsrq;
    /**
     * 信噪比
     * (LTE)
     */
    private Integer rssnr;
    /**
     * 信道质量指标
     * (LTE)
     */
    private Integer cqi;
    /**
     * 时间提前量
     * (GSM,LTE)
     */
    private Integer timingAdvance;
    /**
     * csi信号接收强度
     * (NR)
     */
    private Integer csiRsrp;
    /**
     * csi信号接收质量
     * (NR)
     */
    private Integer csiRsrq;
    /**
     * csi信噪比
     * (NR)
     */
    private Integer csiSinr;
    /**
     * ss信号接收强度
     * (NR)
     */
    private Integer ssRsrp;
    /**
     * ss信号接收质量
     * (NR)
     */
    private Integer ssRsrq;
    /**
     * ss信噪比
     * (NR)
     */
    private Integer ssSinr;

    /**
     * 小区标识
     * (NR)
     */
    private Long nci;

    /**
     * 绝对射频频道号
     * (NR)
     */
    private Integer nrarfcn;

    /**
     * 误码率
     * (GSM，WCDMA)
     */
    private Integer bitErrorRate;
    /**
     * 电信2G Dbm
     */
    private int mCdmaDbm;
    /**
     * 电信2G Ec/Io
     */
    private int mCdmaEcio;
    /**
     * 电信3G Dbm
     */
    private int mEvdoDbm;
    /**
     * 电信3G Ec/Io
     */
    private int mEvdoEcio;
    /**
     * 电信3G 信噪比
     */
    private int mEvdoSnr;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getRegister() {
        return register;
    }

    public void setRegister(Integer register) {
        this.register = register;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMcc() {
        return mcc;
    }

    public void setMcc(Integer mcc) {
        this.mcc = mcc;
    }

    public Integer getMnc() {
        return mnc;
    }

    public void setMnc(Integer mnc) {
        this.mnc = mnc;
    }

    public Integer getLac() {
        return lac;
    }

    public void setLac(Integer lac) {
        this.lac = lac;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getTac() {
        return tac;
    }

    public void setTac(Integer tac) {
        this.tac = tac;
    }

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public Integer getPci() {
        return pci;
    }

    public void setPci(Integer pci) {
        this.pci = pci;
    }

    public Integer getPsc() {
        return psc;
    }

    public void setPsc(Integer psc) {
        this.psc = psc;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getdBm() {
        return dBm;
    }

    public void setdBm(Integer dBm) {
        this.dBm = dBm;
    }

    public Integer getAsuLevel() {
        return asuLevel;
    }

    public void setAsuLevel(Integer asuLevel) {
        this.asuLevel = asuLevel;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getBaseStationType() {
        return baseStationType;
    }

    public void setBaseStationType(String baseStationType) {
        this.baseStationType = baseStationType;
    }

    public Integer getEarfcn() {
        return earfcn;
    }

    public void setEarfcn(Integer earfcn) {
        this.earfcn = earfcn;
    }

    public Integer getBandWidth() {
        return bandWidth;
    }

    public void setBandWidth(Integer bandWidth) {
        this.bandWidth = bandWidth;
    }

    public Integer getArfcn() {
        return arfcn;
    }

    public void setArfcn(Integer arfcn) {
        this.arfcn = arfcn;
    }

    public Integer getBsic() {
        return bsic;
    }

    public void setBsic(Integer bsic) {
        this.bsic = bsic;
    }

    public Integer getUarfcn() {
        return uarfcn;
    }

    public void setUarfcn(Integer uarfcn) {
        this.uarfcn = uarfcn;
    }

    public Integer getRsrp() {
        return rsrp;
    }

    public void setRsrp(Integer rsrp) {
        this.rsrp = rsrp;
    }

    public Integer getRsrq() {
        return rsrq;
    }

    public void setRsrq(Integer rsrq) {
        this.rsrq = rsrq;
    }

    public Integer getRssnr() {
        return rssnr;
    }

    public void setRssnr(Integer rssnr) {
        this.rssnr = rssnr;
    }

    public Integer getCqi() {
        return cqi;
    }

    public void setCqi(Integer cqi) {
        this.cqi = cqi;
    }

    public Integer getTimingAdvance() {
        return timingAdvance;
    }

    public void setTimingAdvance(Integer timingAdvance) {
        this.timingAdvance = timingAdvance;
    }

    public Integer getCsiRsrp() {
        return csiRsrp;
    }

    public void setCsiRsrp(Integer csiRsrp) {
        this.csiRsrp = csiRsrp;
    }

    public Integer getCsiRsrq() {
        return csiRsrq;
    }

    public void setCsiRsrq(Integer csiRsrq) {
        this.csiRsrq = csiRsrq;
    }

    public Integer getCsiSinr() {
        return csiSinr;
    }

    public void setCsiSinr(Integer csiSinr) {
        this.csiSinr = csiSinr;
    }

    public Integer getSsRsrp() {
        return ssRsrp;
    }

    public void setSsRsrp(Integer ssRsrp) {
        this.ssRsrp = ssRsrp;
    }

    public Integer getSsRsrq() {
        return ssRsrq;
    }

    public void setSsRsrq(Integer ssRsrq) {
        this.ssRsrq = ssRsrq;
    }

    public Integer getSsSinr() {
        return ssSinr;
    }

    public void setSsSinr(Integer ssSinr) {
        this.ssSinr = ssSinr;
    }

    public Long getNci() {
        return nci;
    }

    public void setNci(Long nci) {
        this.nci = nci;
    }

    public Integer getNrarfcn() {
        return nrarfcn;
    }

    public void setNrarfcn(Integer nrarfcn) {
        this.nrarfcn = nrarfcn;
    }

    public Integer getBitErrorRate() {
        return bitErrorRate;
    }

    public void setBitErrorRate(Integer bitErrorRate) {
        this.bitErrorRate = bitErrorRate;
    }

    public int getmCdmaDbm() {
        return mCdmaDbm;
    }

    public void setmCdmaDbm(int mCdmaDbm) {
        this.mCdmaDbm = mCdmaDbm;
    }

    public int getmCdmaEcio() {
        return mCdmaEcio;
    }

    public void setmCdmaEcio(int mCdmaEcio) {
        this.mCdmaEcio = mCdmaEcio;
    }

    public int getmEvdoDbm() {
        return mEvdoDbm;
    }

    public void setmEvdoDbm(int mEvdoDbm) {
        this.mEvdoDbm = mEvdoDbm;
    }

    public int getmEvdoEcio() {
        return mEvdoEcio;
    }

    public void setmEvdoEcio(int mEvdoEcio) {
        this.mEvdoEcio = mEvdoEcio;
    }

    public int getmEvdoSnr() {
        return mEvdoSnr;
    }

    public void setmEvdoSnr(int mEvdoSnr) {
        this.mEvdoSnr = mEvdoSnr;
    }

    @Override
    public String toString() {
        return "BaseStation{" +
                "type=" + type +
                ", mcc=" + mcc +
                ", mnc=" + mnc +
                ", lac=" + lac +
                ", cid=" + cid +
                ", tac=" + tac +
                ", ci=" + ci +
                ", pci=" + pci +
                ", psc=" + psc +
                ", sid=" + sid +
                ", nid=" + nid +
                ", bid=" + bid +
                ", dBm=" + dBm +
                ", asuLevel=" + asuLevel +
                ", level=" + level +
                '}';
    }
}
