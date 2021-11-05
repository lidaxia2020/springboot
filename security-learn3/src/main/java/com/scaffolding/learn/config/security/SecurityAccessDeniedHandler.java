package com.scaffolding.learn.config.security;

import com.scaffolding.learn.utils.ResponseUtils;
import com.scaffolding.learn.config.IApplicationConfig;
import com.scaffolding.learn.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/23 22:19
 */
@Component("securityAccessDeniedHandler")
@Slf4j
public class SecurityAccessDeniedHandler implements AccessDeniedHandler {
    @Autowired
    private IApplicationConfig applicationConfig;
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        log.info(request.getRequestURL()+"没有权限");
        ResponseUtils.renderJson(request, response, ResultCode.LIMITED_AUTHORITY, applicationConfig.getOrigins());
    }
}