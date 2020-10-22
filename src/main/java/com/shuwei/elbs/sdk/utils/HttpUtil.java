package com.shuwei.elbs.sdk.utils;

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
        cm.setMaxTotal(1000);
        cm.setDefaultMaxPerRoute(100);

        requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(5000)
                .setConnectTimeout(10000)
                .setSocketTimeout(3000)
                .build();
    }

    public static String httpPostJson(String url, String body, String authorization) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        httpPost.addHeader(AUTHORIZATION_KEY, authorization);
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
    private static String getResult(HttpRequestBase request) {
        CloseableHttpClient httpClient = getHttpClient();
        try(CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity);
            }
        } catch (IOException e) {

        }
        return "";
    }

    /**
     * 通过连接池获取HttpClient
     * @return
     */
    private static CloseableHttpClient getHttpClient() {
        return HttpClients.custom().setConnectionManager(cm).build();
    }

//    public static Response httpPostJson(String url, String body, String authorization) throws Exception {
//        OkHttpClient client = new OkHttpClient.Builder()
//                .connectTimeout(3, TimeUnit.SECONDS)
//                .callTimeout(1, TimeUnit.SECONDS)
//                .build();
//        Request request = new Request.Builder()
//                .url(url)
//                .post(RequestBody.create(MediaType.get("text/plain"), body))
//                .header(AUTHORIZATION_KEY, authorization)
//                .build();
//        return client.newCall(request).execute();
//    }

}
