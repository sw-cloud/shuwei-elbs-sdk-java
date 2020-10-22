package com.shuwei.elbs.sdk.domain;

/**
 * http配置
 */
public class HttpConfig {
    /**
     * 连接池最大连接数
     */
    private int poolMaxTotal;
    /**
     * 每个路由的基础连接数
     */
    private int poolDefaultMaxPerRoute;
    /**
     * 获取连接超时时间
     */
    private int connectionRequestTimeout;
    /**
     * 与服务器连接超时时间
     */
    private int connectionTimeout;
    /**
     * socket读数据超时时间
     */
    private int socketTimeout;

    public static HttpConfig defaultInstance() {
        HttpConfig httpConfig = new HttpConfig();
        httpConfig.setPoolMaxTotal(1000);
        httpConfig.setPoolDefaultMaxPerRoute(100);
        httpConfig.setConnectionRequestTimeout(5000);
        httpConfig.setConnectionTimeout(10000);
        httpConfig.setSocketTimeout(3000);
        return httpConfig;
    }

    public int getPoolMaxTotal() {
        return poolMaxTotal;
    }

    public void setPoolMaxTotal(int poolMaxTotal) {
        this.poolMaxTotal = poolMaxTotal;
    }

    public int getPoolDefaultMaxPerRoute() {
        return poolDefaultMaxPerRoute;
    }

    public void setPoolDefaultMaxPerRoute(int poolDefaultMaxPerRoute) {
        this.poolDefaultMaxPerRoute = poolDefaultMaxPerRoute;
    }

    public int getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    public void setConnectionRequestTimeout(int connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }
}
