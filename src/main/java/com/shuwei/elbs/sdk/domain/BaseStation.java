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
