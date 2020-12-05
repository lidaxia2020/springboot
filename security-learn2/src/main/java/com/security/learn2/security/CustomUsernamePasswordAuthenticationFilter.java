package com.security.learn2.security;

import com.security.learn2.common.ConfigConstant;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义的用户名密码认证过滤器
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/22 13:28
 */
public class CustomUsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private String usernameParameter = "username";
    private String passwordParameter = "password";
    private boolean postOnly = true;

    public CustomUsernamePasswordAuthenticationFilter() {
        /**
         * 设置该过滤器对POST请求/login进行拦截
         */
        super(new AntPathRequestMatcher(ConfigConstant.LOGIN_FORM_SUBMIT_URL, "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (this.postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        } else {
            /**
             * 从http请求中获取用户输入的用户名和密码信息
             * 这里接收的是form形式的参数，如果要接收json形式的参数，修改这里即可
             */
            String username = this.obtainUsername(request);
            String password = this.obtainPassword(request);
            if(StringUtils.isEmpty(username) && StringUtils.isEmpty(password)) {
                throw new UsernameNotFoundException("CustomUsernamePasswordAuthenticationFilter获取用户认证信息失败");
            }
            /**
             * 使用用户输入的用户名和密码信息创建一个未认证的用户认证Token
             */
            CustomUsernamePasswordAuthenticationToken authRequest = new CustomUsernamePasswordAuthenticationToken(username, password);
            /**
             * 设置一些详情信息
             */
            this.setDetails(request, authRequest);
            /**
             * 通过AuthenticationManager调用相应的AuthenticationProvider进行用户认证
             */
            return this.getAuthenticationManager().authenticate(authRequest);
        }
    }

    protected String obtainUsername(HttpServletRequest request) {
        return request.getParameter(this.usernameParameter);
    }

    protected String obtainPassword(HttpServletRequest request) {
        return request.getParameter(this.passwordParameter);
    }

    protected void setDetails(HttpServletRequest request, CustomUsernamePasswordAuthenticationToken authRequest) {
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
    }

    public void setUsernameParameter(String usernameParameter) {
        Assert.hasText(usernameParameter, "Username parameter must not be empty or null");
        this.usernameParameter = usernameParameter;
    }

    public void setPasswordParameter(String passwordParameter) {
        Assert.hasText(passwordParameter, "Password parameter must not be empty or null");
        this.passwordParameter = passwordParameter;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public final String getUsernameParameter() {
        return this.usernameParameter;
    }

    public final String getPasswordParameter() {
        return this.passwordParameter;
    }
}