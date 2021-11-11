package com.lidaxia.springbooti18n;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/5 17:47（
 */
@RestController
@SpringBootApplication
public class SpringbootI18nApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootI18nApplication.class, args);
    }

    @RequestMapping("/i18nTest")
    public ModelAndView i18nTest(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("i18nTest.html");
        return mv;
    }
}
