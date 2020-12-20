package com.security.learn4.service;

import com.security.learn4.model.AuthUser;

/**
 * 用户服务类
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/20 20:43
 */
public interface AuthUserService {

    /**
     * 通过用户账号获取认证用户信息
     */
    AuthUser getAuthUserByUsername(String username);
}
