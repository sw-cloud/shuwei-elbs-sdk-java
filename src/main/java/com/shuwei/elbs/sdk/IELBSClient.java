package com.shuwei.elbs.sdk;

import com.shuwei.elbs.sdk.domain.ELBSRequest;
import com.shuwei.elbs.sdk.domain.ELBSResponse;
import com.shuwei.elbs.sdk.domain.HttpConfig;

public interface IELBSClient {
    /**
     * 定位
     * @param elbsRequest elbs请求参数
     * @return
     */
    ELBSResponse location(ELBSRequest elbsRequest);

    /**
     * 定位
     * @param elbsRequest elbs请求参数
     * @param httpConfig http配置参数
     * @return
     */
    ELBSResponse location(ELBSRequest elbsRequest, HttpConfig httpConfig);
}
