package com.security.learn2.config;

import com.security.learn2.common.ConfigConstant;
import com.security.learn2.security.CustomUsernamePasswordAuthenticationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

import javax.sql.DataSource;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/20 20:16
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsServiceImpl;

    @Autowired
    private CustomUsernamePasswordAuthenticationConfig customUsernamePasswordAuthenticationConfig;


    /**
     * 用户认证配置
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * 指定用户认证时，默认从哪里获取认证用户信息
         */
        auth.userDetailsService(userDetailsServiceImpl);
    }

    /**
     * Http安全配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 表单登录：使用默认的表单登录页面和登录端点/login进行登录
         * 退出登录：使用默认的退出登录端点/logout退出登录
         * 记住我：使用默认的“记住我”功能，把记住用户已登录的Token保存在内存里，记住30分钟
         * 权限：除了/ 和 /toUser之外的其它请求都要求用户已登录
         * 注意：Controller中也对URL配置了权限，如果WebSecurityConfig中和Controller中都对某文化URL配置了权限，则取较小的权限
         */
        http
                .csrf()
                .disable()
                // 调用自定义的用户名密码认证配置类
                .apply(customUsernamePasswordAuthenticationConfig)
                .and()
                .formLogin()
                .loginPage(ConfigConstant.REQUEST_LOGIN_PAGE_URL)
                .loginProcessingUrl(ConfigConstant.LOGIN_FORM_SUBMIT_URL)
                .defaultSuccessUrl(ConfigConstant.DEFAULT_LOGIN_SUCCESSFUL_REQUEST_URL, ConfigConstant.ALWAYS_USE_DEFAULT_LOGIN_SUCCESSFUL_REQUEST_URL)
                .permitAll()
                .and()
                .logout()
                .logoutUrl(ConfigConstant.LOGOUT_URL)
                .logoutSuccessUrl(ConfigConstant.LOGOUT_SUCCESSFUL_REQUEST_URL)
                .logoutRequestMatcher(getLogoutRequestMatchers())
                .permitAll()
                .and()
                .rememberMe()
                //.tokenRepository(getPersistentTokenRepository())
                .tokenValiditySeconds(ConfigConstant.REMEMBER_ME_SECOND)
                .and()
                .authorizeRequests()
                .antMatchers(ConfigConstant.PERMIT_ALL_REQUEST_URL_ARRAY)
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    /**
     * 密码加密器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        /**
         * BCryptPasswordEncoder：相同的密码明文每次生成的密文都不同，安全性更高
         */
        return new BCryptPasswordEncoder();
    }

    /**
     * 指定保存用户登录“记住我”功能的Token的方法：
     * 默认是使用InMemoryTokenRepositoryImpl将Token放在内存中，
     * 如果使用JdbcTokenRepositoryImpl，会创建persistent_logins数据库表，并将Token保存到该表中。
     */
//    @Bean
//    public PersistentTokenRepository getPersistentTokenRepository() {
//        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
//        jdbcTokenRepository.(dataSources);
//        /**
//         * 系统启动时自动创建表，只需要在第一次启动系统时创建即可，因此这行代码只在需要创建表时才启用
//         */
////        jdbcTokenRepository.setCreateTableOnStartup(true);
//        return jdbcTokenRepository;
//    }

    /**
     * 自定义退出登录的RequestMatcher
     */
    private OrRequestMatcher getLogoutRequestMatchers() {
        /**
         * 用户退出登录时，匹配GET请求/logout和POST请求/logout，使得这两种请求都执行退出登录操作
         * 默认情况（未禁用跨域请求伪造，且自定义用户登录页面）下，只对POST请求/logout才执行退出登录操作
         */
        AntPathRequestMatcher getLogoutRequestMatcher = new AntPathRequestMatcher(ConfigConstant.LOGOUT_URL, "GET");
        AntPathRequestMatcher postLogoutRequestMatcher = new AntPathRequestMatcher(ConfigConstant.LOGOUT_URL, "POST");
        return new OrRequestMatcher(getLogoutRequestMatcher, postLogoutRequestMatcher);
    }
}
