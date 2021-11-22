package com.lidaxia.springbootbean;

import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/22 16:30（
 */
@Component
@DependsOn("beanB")
public class BeanA {

    /**
     * @DependsOn的使用：
     *
     *  1、直接或者间接标注在带有@Component注解的类上面;
     *  2、直接或者间接标注在带有@Bean注解的方法上面;
     *  3、使用@DependsOn注解到类层面仅仅在使用 component-scanning 方式时才有效，
     *  如果带有@DependsOn注解的类通过XML方式使用，该注解会被忽略，<bean depends-on="..."/>这种方式会生效。
     */
    public BeanA() {
        System.out.println("BeanA init");
    }
}
