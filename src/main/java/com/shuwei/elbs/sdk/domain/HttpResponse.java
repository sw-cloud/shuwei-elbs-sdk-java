package com.shuwei.elbs.sdk.domain;

import java.io.Serializable;

/**
 * http响应
 */
public class HttpResponse implements Serializable {
    /**
     * 返回的消息体
     */
    private String response;
    /**
     * 响应的http状态码
     */
    private int statusCode;

    public HttpResponse() {
    }

    public HttpResponse(String response, int statusCode) {
        this.response = response;
        this.statusCode = statusCode;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
