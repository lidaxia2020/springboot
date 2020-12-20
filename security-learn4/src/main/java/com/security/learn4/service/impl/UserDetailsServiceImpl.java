package com.security.learn4.service.impl;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/21 10:28
 */

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 自定义的认证用户获取服务类
 */
@Component("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {


    /**
     * 根据用户名获取认证用户信息
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        // 重写UserDetails ,判断用户是否过期
        return new User(username, new BCryptPasswordEncoder().encode("123"), true,
                true, true,
                true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}