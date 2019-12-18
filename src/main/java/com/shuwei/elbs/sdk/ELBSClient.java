package com.shuwei.elbs.sdk;

import com.shuwei.elbs.sdk.constant.CommonConstant;
import com.shuwei.elbs.sdk.constant.RetCode;
import com.shuwei.elbs.sdk.domain.ELBSResponse;
import com.shuwei.elbs.sdk.domain.LocationRequest;
import com.shuwei.elbs.sdk.domain.ELBSRequest;
import com.shuwei.elbs.sdk.utils.AESUtil;
import com.shuwei.elbs.sdk.utils.HttpUtil;
import com.shuwei.elbs.sdk.utils.ShuweiUtil;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/**
 * 定位入口
 */
public final class ELBSClient implements IELBSClient{

    private static Logger logger = LoggerFactory.getLogger(ELBSClient.class);

    // 环境配置，包含appId、appKey、url信息
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
        int code = CommonConstant.DEFAULT_HTTP_RESPONSE_CODE;
        try {
            String encryptedBody = AESUtil.encrypt(requestBody, sKey, ivP);
            logger.trace("encryptedRequest|{}", encryptedBody);
            Response httpResponse = HttpUtil.httpPostJson(this.elbsProfile.getUrl(), encryptedBody, authorization);
            code = httpResponse.code();
            if(httpResponse.isSuccessful() && httpResponse.body() != null){
                String encryptedResponse = httpResponse.body().source().readString(StandardCharsets.UTF_8);
                logger.trace("encryptedResponse|{}", encryptedResponse);
                if(encryptedResponse != null && !"".equals(encryptedResponse)){
                    response = ShuweiUtil.toJsonObj(AESUtil.decrypt(encryptedResponse, sKey, ivP), ELBSResponse.class);
                } else {
                    response = ELBSResponse.newInstance(RetCode.SERVER_ERROR);
                    response.setCode(code);
                }
            }else{
                response = new ELBSResponse();
                response.setCode(code);
            }
        } catch (Exception e) {
            response = ELBSResponse.newInstance(RetCode.SERVER_ERROR);
            response.setCode(code);
            logger.debug("doResponse|{}", RetCode.SERVER_ERROR.getRetCode(), e);
        }

        logger.trace("elbsResponse|{}", ShuweiUtil.toJsonStr(response));
        return response;
    }
}
