package com.security.learn4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/20 20:16
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    /**
     * Http安全配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //.addFilterBefore("","");
                .headers().frameOptions().disable()
                .and()
                .formLogin()
                //  自定义页面
                .loginPage("/login.html")
                // 自定义处理url
                .loginProcessingUrl("/authentication/form")
                // .successHandler(myAuthenticationSuccessHandler)
                .permitAll()
                // .successHandler()
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .and()
//                .rememberMe()
//                .tokenValiditySeconds(1800)
                .and()
                .authorizeRequests()
                .antMatchers("/code/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().
                csrf().disable();
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
}
