package com.lidaxia.springbootbean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/22 16:31（
 */
@Component
public class BeanB {

    public BeanB() {
        System.out.println("BeanB init");
    }
}
