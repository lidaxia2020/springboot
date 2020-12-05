package com.security.learn3.utils;

import com.learn.common.utils.json.JacksonUtils;
import com.security.learn3.config.IApplicationConfig;
import com.security.learn3.exception.CustomException;
import com.security.learn3.result.RestResult;
import com.security.learn3.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/23 22:41
 */
@Slf4j
public class ResponseUtils {

    @Autowired
    private static IApplicationConfig applicationConfig;

    public static void addResponseHeader(HttpServletResponse response , String origins, String originHeader) {
        String[] IPs = origins.split(",");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        // response.setHeader("Access-Control-Allow-Credentials", "true");
        // response.setHeader( "Access-Control-Allow-Headers", "Content-Type");
        if (Arrays.asList(IPs).contains(originHeader)) {
            // todo 先用 * 测试
            response.setHeader("Access-Control-Allow-Origin", originHeader);
        }
    }

    /**
     * 往 response 写出 json
     *
     * @param response 响应
     * @param resultCode 状态
     * @param data     返回数据
     */
    public static void renderJson(HttpServletRequest request, HttpServletResponse response, ResultCode resultCode, Object data, String origins) {
        try {
            String origin = request.getHeader("Origin");
            addResponseHeader(response, origins, origin);
            // setHeader(response);
            response.setStatus(200);

            //  将JSON转为String的时候，忽略null值的时候转成的String存在错误
            response.setContentType("text/javascript; charset=utf-8");
            response.getWriter().write(JacksonUtils.obj2Json(new RestResult(resultCode, data)));
           // response.sendRedirect("/static/login.html");
        } catch (IOException e) {
            log.error("Response写出JSON异常，", e);
        }
    }

    public static void renderJson(HttpServletRequest request, HttpServletResponse response, CustomException e, String origins) {
        renderJson(request, response, e.getResultCode(), origins);
    }

    public static void renderJson(HttpServletRequest request, HttpServletResponse response, ResultCode code, String origins) {
        try {
            String origin = request.getHeader("Origin");
            // setHeader(response);
            addResponseHeader(response, origins, origin);
            response.setStatus(500);

            //  将JSON转为String的时候，忽略null值的时候转成的String存在错误

            response.getWriter().write(JacksonUtils.obj2Json(new RestResult(code)));
        } catch (IOException ex) {
            log.error("Response写出JSON异常，", ex);
        }
    }

    public static void setHeader(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setContentType("application/json;charset=UTF-8");
    }
}

