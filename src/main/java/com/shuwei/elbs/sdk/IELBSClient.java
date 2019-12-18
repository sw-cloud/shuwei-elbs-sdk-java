package com.shuwei.elbs.sdk;

import com.shuwei.elbs.sdk.domain.ELBSRequest;
import com.shuwei.elbs.sdk.domain.ELBSResponse;

public interface IELBSClient {
    /**
     * 定位
     * @param elbsRequest
     * @return
     */
    ELBSResponse location(ELBSRequest elbsRequest);
}
