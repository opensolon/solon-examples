package apidemo3.controller;

import org.noear.solon.annotation.Note;

/**
 * @author noear 2021/6/11 created
 */
public class ApiCodes {
    /**
     * 成功
     */
    @Note("成功")
    public static final ApiCode CODE_200 = new ApiCode(200, "Succeed");

    /**
     * 失败，未知错误
     */
    @Note("失败，未知错误")
    public static final ApiCode CODE_400 = new ApiCode(400, "Unknown error");


    /**
     * 请求的接口不存在或不再支持
     */
    @Note("请求的接口不存在或不再支持")
    public static final ApiCode CODE_4001011 = new ApiCode(4001011, "The api not exist");

    /**
     * 请求的不符合规范
     */
    @Note("请求的不符合规范")
    public static final ApiCode CODE_4001012 = new ApiCode(4001012, "The request is not up to par");


    /**
     * 请求的签名校验失败
     */
    @Note("请求的签名校验失败")
    public static final ApiCode CODE_4001013 = new ApiCode(4001013, "The signature error");

    /**
     * 请求的参数缺少或有错误
     */
    @Note("请求的参数缺少或有错误")
    public static final ApiCode CODE_4001014(String names) {
        return new ApiCode(4001014, names);
    }

    /**
     * 请求太频繁了
     */
    @Note("请求太频繁了")
    public static final ApiCode CODE_4001015 = new ApiCode(4001015, "Too many requests");
    /**
     * 请求不在白名单
     */
    @Note("请求不在白名单")
    public static final ApiCode CODE_4001016 = new ApiCode(4001016, "The request is not in the whitelist");
    /**
     * 请求容量超限
     */
    @Note("请求容量超限")
    public static final ApiCode CODE_4001017 = new ApiCode(4001017, "Request capacity exceeds limit");


    @Note("请求加解密失败")
    public static final ApiCode CODE_4001018 = new ApiCode(4001018, "The request for encryption and decryption failed");


    /**
     * 登录已失效
     */
    @Note("登录已失效或未登录")
    public static final ApiCode CODE_4001021 = new ApiCode(4001021, "Login is invalid or not logged in");
}
