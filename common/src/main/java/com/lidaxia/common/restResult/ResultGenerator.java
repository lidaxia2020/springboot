package com.lidaxia.common.restResult;

/**
 * 返回的状态码
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/20 20:16
 */
public class ResultGenerator {

    public static RestResult genSuccessResult() {
        return new RestResult(ResultCode.SUCCESS);
    }

    public static <T> RestResult<T> genSuccessResult(T data) {

        return new RestResult(200, "SUCCESS", data);
    }

    public static RestResult genFailResult(String message) {
        return new RestResult(ResultCode.FAIL.getCode(), message);
    }

    public static RestResult genErrorResult(String message) {
        return new RestResult(ResultCode.ERROR.getCode(), message);
    }



    /**
     * 未验证error 构造器
     * @return
     */
    public static RestResult genUnauthResult() {
        return new RestResult(ResultCode.UNAUTHORIZED);
    }
}
