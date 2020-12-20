package com.security.learn4.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/12/20 16:34
 */
public class RbacServiceImpl implements RbacService{
    
    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        
        boolean hasPermission = false;
        
        if (principal instanceof UserDetails){
            String username = ((UserDetails) principal).getUsername();
            Set<String> urls = new HashSet<>();

            // 读取用户所有权限的所有URL
            for (String url : urls){
                if (antPathMatcher.match(url, request.getRequestURI())){
                    hasPermission = true;
                     break;
                }
            }




        }


        return hasPermission;
    }
}
