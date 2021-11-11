package com.lidaxia.springbootmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/11 16:52（
 */
@SpringBootApplication
@MapperScan("com.lidaxia.springbootmybatisplus.*.mapper")
public class SpringbootMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisPlusApplication.class, args);
    }

}