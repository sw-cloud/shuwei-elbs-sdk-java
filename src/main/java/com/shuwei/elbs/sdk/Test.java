package com.shuwei.elbs.sdk;

import com.shuwei.elbs.sdk.domain.ELBSRequest;
import com.shuwei.elbs.sdk.domain.ELBSResponse;
import com.shuwei.elbs.util.common.JsonUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    private static ELBSProfile elbsProfile = new ELBSProfile(
            "78873eca68dc",
            "17ebb09c-fcf7-45ef-b07a-26dd51e84be8",
            "http://api.jjfinder.com/v3/test/scene/api"
    );



    private static ELBSRequest elbsRequest = JsonUtils.toObject("{\n" +
            "    \"appId\":\"2a1092f5308e\",\n" +
            "    \"baseStationList\":[\n" +
            "        {\n" +
            "            \"ci\":37411586,\n" +
            "            \"dBm\":-1,\n" +
            "            \"mCdmaDbm\":0,\n" +
            "            \"mCdmaEcio\":0,\n" +
            "            \"mEvdoDbm\":0,\n" +
            "            \"mEvdoEcio\":0,\n" +
            "            \"mEvdoSnr\":0,\n" +
            "            \"mcc\":460,\n" +
            "            \"pci\":460,\n" +
            "            \"rsrp\":-84,\n" +
            "            \"rsrq\":-4,\n" +
            "            \"rssnr\":31,\n" +
            "            \"tac\":13150,\n" +
            "            \"type\":4\n" +
            "        }\n" +
            "    ],\n" +
            "    \"networkMode\":\"4\",\n" +
            "    \"oid\":\"865593043417234\",\n" +
            "    \"oidType\":\"1\",\n" +
            "    \"sign\":\"69cb8108fc678e145c1c0496f4991d1f2bb11e05\",\n" +
            "    \"ssidEncode\":1,\n" +
            "    \"timestamp\":1603258585593\n" +
            "}", ELBSRequest.class);
    private static ELBSClient elbsClient = new ELBSClient(elbsProfile);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i=0;i<10000;i++) {
//            Thread.sleep(1000L);
            final int j = i;
            executorService.execute(() -> {
                ELBSResponse location = elbsClient.location(elbsRequest);
                System.out.println(j + ":"+location);
            });

//            if (elbsResponse == null) {
//                System.out.println("response is null:" + i);
//                continue;
//            }
//
//            if (elbsResponse.getCode() != 200 || elbsResponse.getRetCode() != 0) {
//                System.out.println("request error:" + elbsResponse.getRetCode() + ":" + i);
//            }
        }
    }
}
