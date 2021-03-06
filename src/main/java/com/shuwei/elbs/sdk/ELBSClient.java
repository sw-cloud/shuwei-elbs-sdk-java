package com.shuwei.elbs.sdk;

import com.shuwei.elbs.sdk.constant.CommonConstant;
import com.shuwei.elbs.sdk.constant.RetCode;
import com.shuwei.elbs.sdk.domain.*;
import com.shuwei.elbs.sdk.utils.AESUtil;
import com.shuwei.elbs.sdk.utils.HttpUtil;
import com.shuwei.elbs.sdk.utils.ShuweiUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定位入口
 */
public final class ELBSClient implements IELBSClient{

    private static Logger logger = LoggerFactory.getLogger(ELBSClient.class);

    /**
     * 环境配置，包含appId、appKey、url信息
     */
    private ELBSProfile elbsProfile;

    public ELBSClient(ELBSProfile elbsProfile) {
        this.elbsProfile = elbsProfile;
    }



    /**
     * ELBS定位入口
     * @param elbsRequest ELBS请求信息
     * @return ELBS定位结果
     */
    @Override
    public ELBSResponse location(ELBSRequest elbsRequest) {
        return location(elbsRequest, HttpConfig.defaultInstance());
    }

    @Override
    public ELBSResponse location(ELBSRequest elbsRequest, HttpConfig httpConfig) {
        if(elbsRequest == null || this.elbsProfile == null){
            return ELBSResponse.newInstance(RetCode.REQUEST_DATA_IS_NULL);
        }

        logger.trace("requestInfo|requestData={}|elbsProfile={}", ShuweiUtil.toJsonStr(elbsRequest), ShuweiUtil.toJsonStr(elbsProfile));

        if(this.elbsProfile.lackNeedParams() || elbsRequest.lackNeedParams()){
            logger.debug("doResponse|{}", RetCode.LACK_NEED_PARAMS.getRetCode());
            return ELBSResponse.newInstance(RetCode.LACK_NEED_PARAMS);
        }

        if(!this.elbsProfile.formatCheck() || !elbsRequest.formatCheck()){
            logger.debug("doResponse|{}", RetCode.PARAMS_FORMAT_ERROR.getRetCode());
            return ELBSResponse.newInstance(RetCode.PARAMS_FORMAT_ERROR);
        }

        LocationRequest locationRequest = LocationRequest.newInstanceByRequestData(elbsRequest, this.elbsProfile.getAppId(), this.elbsProfile.getAppKey());
        String requestBody = ShuweiUtil.toJsonStr(locationRequest);
        logger.trace("requestBody|{}", requestBody);

        String authorization = locationRequest.authorization();
        logger.trace("authorization|{}", authorization);

        HttpUtil.init(httpConfig);
        return responseFromHttp(requestBody, authorization);
    }

    /**
     * 通过http获取场景识别结果
     * @param requestBody
     * @param authorization
     * @return
     */
    private ELBSResponse responseFromHttp(String requestBody, String authorization){
        String appKeyTmp = this.elbsProfile.getAppKey().replaceAll("-", "");
        String sKey = appKeyTmp.substring(0, CommonConstant.LENGTH_OF_ENCRYPT_KEY);
        String ivP = appKeyTmp.substring(CommonConstant.LENGTH_OF_ENCRYPT_KEY);

        ELBSResponse response;
        try {
            String encryptedBody = AESUtil.encrypt(requestBody, sKey, ivP);
            logger.trace("encryptedRequest|{}", encryptedBody);
            HttpResponse httpResponse = HttpUtil.httpPostJson(this.elbsProfile.getUrl(), encryptedBody, authorization);
            int code = httpResponse.getStatusCode();
            if(code == CommonConstant.DEFAULT_HTTP_RESPONSE_CODE){
                logger.trace("encryptedResponse|{}", httpResponse);
                response = ShuweiUtil.toJsonObj(AESUtil.decrypt(httpResponse.getResponse(), sKey, ivP), ELBSResponse.class);
            }else{
                response = ELBSResponse.newInstance(RetCode.CLIENT_ERROR);
                response.setCode(code);
                logger.debug("connectFail|{}", RetCode.CLIENT_ERROR.getRetCode());
            }
        } catch (Exception e) {
            response = ELBSResponse.newInstance(RetCode.CLIENT_ERROR);
            response.setCode(CommonConstant.DEFAULT_HTTP_ERROR_CODE);
            logger.debug("doResponse|{}", RetCode.CLIENT_ERROR.getRetCode(), e);
        }

        logger.trace("elbsResponse|{}", ShuweiUtil.toJsonStr(response));
        return response;
    }
}
