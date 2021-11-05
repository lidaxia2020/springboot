package com.scaffolding.learn.config.security;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.scaffolding.learn.config.CustomConfig;
import com.scaffolding.learn.utils.JwtUtils;
import com.scaffolding.learn.utils.ResponseUtils;
import com.scaffolding.learn.config.IApplicationConfig;
import com.scaffolding.learn.exception.CustomException;
import com.scaffolding.learn.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/23 22:18
 */
@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private SecurityUserService userDetailsService;

    @Autowired
    private JwtUtils jwtUtil;

    @Autowired
    private CustomConfig customConfig;

    @Autowired
    private IApplicationConfig applicationConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        // 是否为放行的请求
        if (checkIgnores(request)) {
            chain.doFilter(request, response);
            return;
        }

        String jwt = jwtUtil.getJwtFromRequest(request);

        if (StrUtil.isNotBlank(jwt)) {
            try {
                String username = jwtUtil.getUsernameFromJWT(jwt, false);

                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);

                chain.doFilter(request, response);
            } catch (CustomException e) {
                ResponseUtils.renderJson(request, response, e, applicationConfig.getOrigins());
            }
        } else {
            ResponseUtils.renderJson(request, response, ResultCode.UNAUTHORIZED, null, applicationConfig.getOrigins());
        }

    }

    /**
     * 请求是否不需要进行权限拦截
     *
     * @param request 当前请求
     * @return true - 忽略，false - 不忽略
     */
    private boolean checkIgnores(HttpServletRequest request) {
        String method = request.getMethod();

        HttpMethod httpMethod = HttpMethod.resolve(method);
        if (ObjectUtil.isNull(httpMethod)) {
            httpMethod = HttpMethod.GET;
        }

        Set<String> ignores = new HashSet();

        switch (httpMethod) {
            case GET:
                ignores.addAll(customConfig.getIgnores()
                        .getGet());
                break;
            case PUT:
                ignores.addAll(customConfig.getIgnores()
                        .getPut());
                break;
            case HEAD:
                ignores.addAll(customConfig.getIgnores()
                        .getHead());
                break;
            case POST:
                ignores.addAll(customConfig.getIgnores()
                        .getPost());
                break;
            case PATCH:
                ignores.addAll(customConfig.getIgnores()
                        .getPatch());
                break;
            case TRACE:
                ignores.addAll(customConfig.getIgnores()
                        .getTrace());
                break;
            case DELETE:
                ignores.addAll(customConfig.getIgnores()
                        .getDelete());
                break;
            case OPTIONS:
                ignores.addAll(customConfig.getIgnores()
                        .getOptions());
                break;
            default:
                break;
        }

        ignores.addAll(customConfig.getIgnores()
                .getPattern());

        if (CollUtil.isNotEmpty(ignores)) {
            for (String ignore : ignores) {
                AntPathRequestMatcher matcher = new AntPathRequestMatcher(ignore, method);
                if (matcher.matches(request)) {
                    return true;
                }
            }
        }

        return false;
    }
}
