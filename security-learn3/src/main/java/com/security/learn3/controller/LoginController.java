package com.security.learn3.controller;

import com.security.learn3.exception.CustomException;
import com.security.learn3.result.RestResult;
import com.security.learn3.result.ResultCode;
import com.security.learn3.utils.CookieUtils;
import com.security.learn3.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/28 18:38
 */
@Slf4j
@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationMnager;

    @Autowired
    private JwtUtils jwtUtil;


    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @param rememberMe
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/login")
    public RestResult login(@RequestParam String username,
                            @RequestParam String password,
                            @RequestParam(required = false, defaultValue = "true") Boolean rememberMe,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        Authentication authentication = authenticationMnager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);

        String jwt = jwtUtil.createJWT(authentication, rememberMe, false);
        String jwt_refresh = jwtUtil.createJWT(authentication, rememberMe, true);
        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);
        map.put("refreshToken", jwt_refresh);

        CookieUtils.setCookie(response, "localhost", jwt);
        return new RestResult(200, "登录成功", map);
    }

    /**
     * 退出
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public RestResult logout(HttpServletRequest request) {
        try {
            // 设置JWT过期
            jwtUtil.invalidateJWT(request);
        } catch (CustomException e) {
            throw new CustomException(ResultCode.UNAUTHORIZED);
        }
        return new RestResult(200, "退出成功");

    }

    /**
     * 刷新过期的token
     * @param refreshToken
     * @return
     */
    @PostMapping("/refresh/token")
    public RestResult refreshToken(String refreshToken) {
        Map<String, String> map;
        try {
            // 刷新
            map = jwtUtil.refreshJWT(refreshToken);
        } catch (CustomException e) {
            throw new CustomException(ResultCode.TOKEN_EXPIRED);
        }
        return new RestResult(200, "token刷新成功", map);
    }
}