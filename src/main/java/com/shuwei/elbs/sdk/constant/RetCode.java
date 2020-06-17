package com.shuwei.elbs.sdk.constant;

/**
 * 响应码
 */
public final class RetCode {
    /** 成功 */
    public static final RetCode SUCCESS= new RetCode(0, "OK");

    /** 客户端错误 */
    public static final RetCode CLIENT_ERROR= new RetCode(100000, "Client error");
    /** 服务器错误 */
    public static final RetCode SERVER_ERROR= new RetCode(100001, "System error");
    /** 环境错误 */
    public static final RetCode ENVIRONMENT_ERROR= new RetCode(100002, "ELBSProfile error");
    /** 缺少必传参数 */
    public static final RetCode LACK_NEED_PARAMS= new RetCode(100003, "Miss required parameter");
    /** 参数格式错误 */
    public static final RetCode PARAMS_FORMAT_ERROR= new RetCode(100004, "Parameter value invalid");
    /** 签名错误 */
    public static final RetCode SIGN_ERROR= new RetCode(100005, "Sign error");
    /** 包名错误 */
    public static final RetCode PACKAGE_NAME_ERROR= new RetCode(100006, "Package name error");
    /** 请求数据为空 */
    public static final RetCode REQUEST_DATA_IS_NULL= new RetCode(100007, "Request data is null");
    /** 头部缺少授权数据 */
    public static final RetCode LACK_AUTHORIZATION= new RetCode(100008, "Restricted access.Lack authorization");
    /** 达到qps上限 */
    public static final RetCode APP_TPS_REACH_LIMIT= new RetCode(100009, "Restricted access.App TPS reach limit");
    /** 每日配额达到上限 */
    public static final RetCode REACH_DAILY_TPD_LIMIT= new RetCode(100010, "Restricted access.Transaction reach daily limit");
    /** Server tps 达到上限 */
    public static final RetCode SERVER_TPS_REACH_LIMIT= new RetCode(100011, "Restricted access.TPS reach limit");
    /** 接口版本错误 */
    public static final RetCode API_VERSION_ERROR = new RetCode(100012, "Api version is wrong");
    /** 没有权限执行此操作 */
    public static final RetCode NO_AUTHORITY = new RetCode(100016, "No permission to perform this operation");
    /** 信号无效**/
    public static final RetCode SIGNAL_INVALID = new RetCode(100018, "Signal invalid");
    /** ssidEncode 错误**/
    public static final RetCode SSID_ENCODE_VALUE_ERROR = new RetCode(100019, "SsidEncode value error");
    /** 无定位结果 */
    public static final RetCode SCENE_NO_RESULT= new RetCode(201001, "No result");

    private RetCode(int retCode, String msg) {
        this.retCode = retCode;
        this.msg = msg;
    }
    // 响应码
    private int retCode;
    // 响应信息
    private String msg;

    public int getRetCode() {
        return retCode;
    }

    public String getMsg() {
        return msg;
    }
}
