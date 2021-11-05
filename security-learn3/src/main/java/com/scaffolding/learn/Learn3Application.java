package com.scaffolding.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author lidaxia
 */
@MapperScan("com.security.learn3.mapper")
@EnableSwagger2
@SpringBootApplication
public class Learn3Application {

    public static void main(String[] args) {
        SpringApplication.run(Learn3Application.class, args);
    }

}
