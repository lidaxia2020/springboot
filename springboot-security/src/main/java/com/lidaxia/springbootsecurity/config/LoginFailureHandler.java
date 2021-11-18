package com.lidaxia.springbootsecurity.config;

import com.lidaxia.common.restResult.RestResult;
import com.lidaxia.common.restResult.ResultCode;
import com.lidaxia.common.restResult.ResultGenerator;
import com.lidaxia.common.utils.json.JacksonUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/16 15:03（
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        System.out.println("用户名或密码错误");
        //响应json
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        RestResult restResult = ResultGenerator.genFailResult(ResultCode.LOGIN_ERROR);
        out.print(JacksonUtils.obj2Json(restResult));
        out.flush();
        out.close();
    }
}