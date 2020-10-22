package com.shuwei.elbs.sdk.utils;

import com.shuwei.elbs.sdk.constant.CommonConstant;
import com.shuwei.elbs.sdk.domain.HttpConfig;
import com.shuwei.elbs.sdk.domain.HttpResponse;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Http工具类
 */
public final class HttpUtil {
    private HttpUtil(){}

    private static final String AUTHORIZATION_KEY = "Authorization";
    private static final Object syncObj = new Object();
    /**
     * 连接管理对象
     */
    private static PoolingHttpClientConnectionManager cm;
    /**
     * 请求
     */
    private static RequestConfig requestConfig;

    public static void init() {
        init(null);
    }

    public static void init(HttpConfig httpConfig) {
        if (httpConfig == null) {
            httpConfig = HttpConfig.defaultInstance();
        }
        if (cm == null) {
           synchronized (syncObj) {
               if (cm == null) {
                   cm = new PoolingHttpClientConnectionManager();
                   cm.setMaxTotal(httpConfig.getPoolMaxTotal());
                   cm.setDefaultMaxPerRoute(httpConfig.getPoolDefaultMaxPerRoute());
               }
           }
        }

        if (requestConfig == null) {
            synchronized (syncObj) {
                if (requestConfig == null) {
                    requestConfig = RequestConfig.custom()
                            .setConnectionRequestTimeout(httpConfig.getConnectionRequestTimeout())
                            .setConnectTimeout(httpConfig.getConnectionTimeout())
                            .setSocketTimeout(httpConfig.getSocketTimeout())
                            .build();
                }
            }
        }
    }

    /**
     * 发送http请求
     * @param url
     * @param body
     * @param authorization
     * @return
     */
    public static HttpResponse httpPostJson(String url, String body, String authorization) {
        HttpPost httpPost = new HttpPost(url);
        if (requestConfig == null) {
            init();
        }
        httpPost.setConfig(requestConfig);
        httpPost.addHeader(AUTHORIZATION_KEY, authorization);
        httpPost.addHeader("Connection", "keep-alive");
        ContentType contentType = ContentType.create("application/json", Consts.UTF_8);
        StringEntity entity = new StringEntity(body, contentType);
        httpPost.setEntity(entity);
        return getResponse(httpPost);
    }

    /**
     * 获取Http响应
     *
     * @param request
     * @return
     */
    private static HttpResponse getResponse(HttpRequestBase request) {
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = null;
        int statusCode = CommonConstant.DEFAULT_HTTP_ERROR_CODE;
        try {
            response = httpClient.execute(request);
            statusCode = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String responseBody = EntityUtils.toString(entity);
                return new HttpResponse(responseBody, statusCode);
            }
        } catch (IOException e) {
            return new HttpResponse(null, statusCode);
        }
        return new HttpResponse(null, statusCode);
    }

    /**
     * 通过连接池获取HttpClient
     * @return
     */
    private static CloseableHttpClient getHttpClient() {
        if (cm == null) {
            init();
        }
        return HttpClients.custom().setConnectionManager(cm).build();
    }

}
