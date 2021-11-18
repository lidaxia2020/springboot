package com.lidaxia.springbootsecurity.config;

import com.lidaxia.common.restResult.RestResult;
import com.lidaxia.common.restResult.ResultCode;
import com.lidaxia.common.restResult.ResultGenerator;
import com.lidaxia.common.utils.json.JacksonUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/16 15:02（
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("登录成功");
        //响应json
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        RestResult restResult = ResultGenerator.genSuccessResult();
        out.print(JacksonUtils.obj2Json(restResult));
        out.flush();
        out.close();
    }
}
