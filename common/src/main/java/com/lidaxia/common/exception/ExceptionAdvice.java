package com.lidaxia.common.exception;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/12 10:13（
 */

import com.lidaxia.common.restResult.RestResult;
import com.lidaxia.common.restResult.ResultGenerator;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.List;

/**
 * 统一异常处理
 *
 * @author lidaxia
 * @desc
 * @date 2021/11/11 15:41（
 */
@RestControllerAdvice
public class ExceptionAdvice {

    /**
     * validation参数校验异常 统一处理
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public RestResult exceptionHandler500(BindException e) {

        String message = formatAllErrorMessages(e.getBindingResult().getAllErrors());
        return ResultGenerator.genFailResult("【参数校验失败】 " + message);
    }

    @ExceptionHandler()
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public RestResult handleBeanValidation(HttpServletRequest reg, MethodArgumentNotValidException e) {

        String message = formatAllErrorMessages(e.getBindingResult().getAllErrors());
        return ResultGenerator.genFailResult("【参数校验失败】 " + message);
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public RestResult handleBeanValidation(HttpServletRequest reg, ValidationException e) {

        return ResultGenerator.genFailResult("【参数校验失败】 " + e.getMessage());
    }

    /**
     * 拼接报错信息
     *
     * @param errors
     * @return
     */
    private String formatAllErrorMessages(List<ObjectError> errors) {
        StringBuffer errorMsgs = new StringBuffer();
        errors.forEach(error -> errorMsgs.append(error.getDefaultMessage()).append(";"));
        return errorMsgs.toString();
    }


    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public RestResult exceptionHandler500(ConstraintViolationException e) {
        e.printStackTrace();
        StringBuilder stringBuilder = new StringBuilder();
        for (ConstraintViolation<?> error : e.getConstraintViolations()) {
            PathImpl pathImpl = (PathImpl) error.getPropertyPath();
            String paramName = pathImpl.getLeafNode().getName();
            stringBuilder.append("[");
            stringBuilder.append(paramName);
            stringBuilder.append(" ");
            stringBuilder.append(error.getMessage());
            stringBuilder.append("]");
        }
        return ResultGenerator.genFailResult("【参数校验失败】 " + stringBuilder.toString());
    }

    /**
     * 未知异常 统一处理
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestResult exceptionHandler(Exception e) {
        e.printStackTrace();
        return ResultGenerator.genErrorResult("【未知异常】 " + e.getMessage());
    }
}