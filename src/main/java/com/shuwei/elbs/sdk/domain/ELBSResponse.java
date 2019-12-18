package com.shuwei.elbs.sdk.domain;

import com.shuwei.elbs.sdk.constant.CommonConstant;
import com.shuwei.elbs.sdk.constant.RetCode;
import okhttp3.Request;

import java.util.Map;

/**
 * ELBS响应信息
 */
public class ELBSResponse {
    /**
     * http状态码
     */
    private Integer code = CommonConstant.DEFAULT_HTTP_RESPONSE_CODE;
    /**
     * 响应码
     * @see com.shuwei.elbs.sdk.constant.RetCode
     */
    private Integer retCode;
    /**
     * 响应信息
     * @see com.shuwei.elbs.sdk.constant.RetCode
     */
    private String msg;
    /**
     * 定位信息
     */
    private Map<String, Object> data;

    public static ELBSResponse newInstance(RetCode retCode){
        ELBSResponse elbsResponse;
        if(retCode == null){
            elbsResponse = newInstance(RetCode.SUCCESS);
        }else{
            elbsResponse = new ELBSResponse();
            elbsResponse.setRetCode(retCode.getRetCode());
            elbsResponse.setMsg(retCode.getMsg());
        }
        return elbsResponse;
    }

    public ELBSResponse() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ELBSResponse{" +
                "code=" + code +
                ", retCode=" + retCode +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
