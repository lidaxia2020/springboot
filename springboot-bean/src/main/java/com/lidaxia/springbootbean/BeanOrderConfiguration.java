package com.lidaxia.springbootbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/22 16:31（
 */
//@Configuration
public class BeanOrderConfiguration {

    @Bean
    @DependsOn("beanA")
    public BeanB beanB() {
        return new BeanB();
    }


    @Bean
    public BeanA beanA() {
        return new BeanA();
    }


}
