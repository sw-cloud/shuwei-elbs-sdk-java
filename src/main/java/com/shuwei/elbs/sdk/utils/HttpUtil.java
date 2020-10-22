package com.shuwei.elbs.sdk.utils;

import com.shuwei.elbs.sdk.constant.CommonConstant;
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

    /**
     * 连接管理对象
     */
    private static PoolingHttpClientConnectionManager cm;
    /**
     * 请求
     */
    private static RequestConfig requestConfig;

    static {
        cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(200);
        cm.setDefaultMaxPerRoute(20);

        requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(5000)
                .setConnectTimeout(10000)
                .setSocketTimeout(3000)
                .build();
    }

    public static HttpResponse httpPostJson(String url, String body, String authorization) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        httpPost.addHeader(AUTHORIZATION_KEY, authorization);
        httpPost.addHeader("Connection", "keep-alive");
        ContentType contentType = ContentType.create("application/json", Consts.UTF_8);
        StringEntity entity = new StringEntity(body, contentType);
        httpPost.setEntity(entity);
        return getResult(httpPost);
    }

    /**
     * 处理Http请求
     *
     * @param request
     * @return
     */
    private static HttpResponse getResult(HttpRequestBase request) {
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
            e.printStackTrace();
            return new HttpResponse(null, statusCode);
        }
        return new HttpResponse(null, statusCode);
    }

    /**
     * 通过连接池获取HttpClient
     * @return
     */
    private static CloseableHttpClient getHttpClient() {
        return HttpClients.custom().setConnectionManager(cm).build();
    }

}
