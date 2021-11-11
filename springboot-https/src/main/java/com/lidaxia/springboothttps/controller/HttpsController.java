package com.lidaxia.springboothttps.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/11 14:58（
 */
@RestController
public class HttpsController {

    @GetMapping("/hello")
    public String hello() {
        return "SpringBoot系列——启用https";
    }


    @PostMapping("/test")
    @ResponseBody
    public Map test(@RequestBody Map map) {

        System.out.println("map = " + map);
        Map map1 = new HashMap(1);
        map1.put("test", "test");

        return map1;
    }



}