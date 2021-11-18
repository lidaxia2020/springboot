package com.lidaxia.springwebflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/18 17:48（
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Mono<String> hello() {
        /**
         * 使用Mono.just生成响应式数据
         */
        return Mono.just("Welcome to reactive world ~");
    }
}
