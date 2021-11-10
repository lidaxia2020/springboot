package com.lidaxia.springbootcors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/5 17:29（
 */
@RestController
@SpringBootApplication
public class SpringbootCorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCorsApplication.class, args);
    }

    @RequestMapping("/")
    public String index(){
        return "欢迎访问 springboot-aop";
    }
}
