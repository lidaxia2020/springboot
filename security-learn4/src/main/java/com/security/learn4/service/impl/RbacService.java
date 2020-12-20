package com.security.learn4.service.impl;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/20 16:33
 */
public interface RbacService {

    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
