package com.security.learn4.service.impl;

import com.security.learn4.model.AuthUser;
import com.security.learn4.service.AuthUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/20 20:44
 */
@Service
public class AuthUserServiceImpl implements AuthUserService {


    @Override
    public AuthUser getAuthUserByUsername(String username) {
        /**
         * 实际上这里应该是从数据库中查询或者是调用其它服务接口获取，
         * 为了方便，这里直接创建用户信息
         * admin用户拥有 ROLE_ADMIN 和 ROLE_EMPLOYEE 这两个角色
         * employee用户拥有 ROLE_EMPLOYEE 这个角色
         * temp用户没有角色
         */
        String password = new BCryptPasswordEncoder().encode("123");
        if(username.equals("admin")) {
            AuthUser user = new AuthUser();
            user.setId(1L);
            user.setUsername("admin");
            /**
             * 密码为123（通过BCryptPasswordEncoderl加密后的密文）
             */
            user.setPassword(password);
            List<String> roles = new ArrayList<>();
            roles.add("ROLE_ADMIN");
            roles.add("ROLE_EMPLOYEE");
            user.setRoles(roles);
            return user;
        } else if(username.equals("employee")) {
            AuthUser user = new AuthUser();
            user.setId(2L);
            user.setUsername("employee");
            /**
             * 密码为123（通过BCryptPasswordEncoderl加密后的密文）
             */
            user.setPassword(password);
            List<String> roles = new ArrayList<>();
            roles.add("ROLE_EMPLOYEE");
            user.setRoles(roles);
            return user;
        } else if (username.equals("temp")) {
            AuthUser user = new AuthUser();
            user.setId(3L);
            user.setUsername("temp");
            /**
             * 密码为123（通过BCryptPasswordEncoderl加密后的密文）
             */
            user.setPassword(password);
            List<String> roles = new ArrayList<>();
            user.setRoles(roles);
            return user;
        } else {
            return null;
    }
}}
