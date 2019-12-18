package com.shuwei.elbs.sdk.utils;

import okhttp3.*;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * Http工具类
 */
public final class HttpUtil {
    private HttpUtil(){}

    private static final String AUTHORIZATION_KEY = "Authorization";

    public static Response httpPostJson(String url, String body, String authorization) throws Exception {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .callTimeout(1, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(MediaType.get("text/plain"), body))
                .header(AUTHORIZATION_KEY, authorization)
                .build();
        return client.newCall(request).execute();
    }
}
