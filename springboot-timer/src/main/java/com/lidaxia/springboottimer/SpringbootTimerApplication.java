package com.lidaxia.springboottimer;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/11 15:52（
 */
@EnableScheduling //启用定时器
@SpringBootApplication
public class SpringbootTimerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTimerApplication.class, args);
    }

    /**
     * 启动成功
     */
    @Bean
    public ApplicationRunner applicationRunner() {
        return applicationArguments -> {
            System.out.println("启动成功！");
        };
    }
}