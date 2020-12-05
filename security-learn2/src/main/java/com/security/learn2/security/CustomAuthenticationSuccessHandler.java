package com.security.learn2.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.learn2.common.ConfigConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义的用户认证成功处理器
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/22 13:41
 */
@Component("customAuthenticationSuccessHandler")
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    public CustomAuthenticationSuccessHandler() {
        /**
         * 指定默认登录成功请求的URL和是否总是使用默认登录成功请求的URL
         * 注意：自定义的认证成功处理器，如果不指定，默认登录成功请求的URL是"/"
         */
        this.setDefaultTargetUrl(ConfigConstant.DEFAULT_LOGIN_SUCCESSFUL_REQUEST_URL);
        this.setAlwaysUseDefaultTargetUrl(ConfigConstant.ALWAYS_USE_DEFAULT_LOGIN_SUCCESSFUL_REQUEST_URL);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException, IOException, ServletException {
        /**
         * 如果配置ConfigConstant.LOGIN_RESPONSE_TYPE="JSON"，则返回JSON，否则使用页面跳转
         */
        if("JSON".equalsIgnoreCase(ConfigConstant.LOGIN_RESPONSE_TYPE)) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(authentication));
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }

}