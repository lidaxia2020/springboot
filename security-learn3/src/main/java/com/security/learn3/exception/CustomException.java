package com.security.learn3.exception;

import com.security.learn3.result.ResultCode;
import lombok.Data;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/24 0:14
 */
@Data
public class CustomException extends RuntimeException {

    private Integer code;

    private ResultCode resultCode;

    public CustomException(){
    }

    public CustomException(ResultCode resultCode){
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
        this.resultCode = resultCode;
    }


    public CustomException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
