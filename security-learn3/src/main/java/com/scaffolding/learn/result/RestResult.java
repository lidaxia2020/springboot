package com.scaffolding.learn.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/24 23:04
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResult<T> {
    private int code;

    private String message;

    private  T data;

    public int getCode() {
        return code;
    }

    public RestResult() {
    }

    public RestResult(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public RestResult(Integer code, String  message){
        this.code = code;
        this.message = message;
    }

    public RestResult(Integer code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public RestResult(ResultCode resultCode, T data){
        this(resultCode);
        this.data = data;
    }

    public RestResult setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RestResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public RestResult setData(T data) {
        this.data = data;
        return this;
    }

    /**
     * WARN: fastjson关闭了引用监测，在循环引用时可能会内存溢出
     * - 如果前端能够解析$ref 指针引用,则考虑开启引用监测
     * - 先默认前端不能解析
     */
//    public String toJson() {
//        return JSON.toJSONStringWithDateFormat(this, Constant.DATE_FORMATTER_TIME, SerializerFeature.DisableCircularReferenceDetect);
//    }
}
