package com.lidaxia.springwebflux.config;

import com.lidaxia.springwebflux.component.TimeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


/**
 * @author lidaxia
 * @desc
 * @date 2021/11/18 17:58（
 */
@Configuration
public class RouterConfig {
    @Autowired
    private TimeHandler timeHandler;

    @Bean
    public RouterFunction<ServerResponse> timerRouter() {

        return RouterFunctions.route(RequestPredicates.GET("/time"), req -> timeHandler.getTime(req))
                // 这种方式相对于上一行更加简洁
                .andRoute(RequestPredicates.GET("/date"), timeHandler::getDate)
                .andRoute(RequestPredicates.GET("/times"), timeHandler::sendTimePerSec);
    }
}
