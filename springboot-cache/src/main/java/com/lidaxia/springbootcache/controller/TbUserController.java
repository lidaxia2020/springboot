package com.lidaxia.springbootcache.controller;

import com.lidaxia.springbootcache.pojo.TbUser;
import com.lidaxia.springbootcache.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tbUser/")
public class TbUserController {
    @Autowired
    private TbUserService tbUserService;

    //方便测试暂时改成GetMapping
    @GetMapping("list")
//    @PostMapping("list")
    public List<TbUser> list(TbUser entityVo) {
        return tbUserService.list(entityVo);
    }

    @GetMapping("get/{id}")
    public TbUser get(@PathVariable("id") Integer id) {
        return tbUserService.get(id);
    }

    //方便测试暂时改成GetMapping
    @GetMapping("save")
//    @PostMapping("save")
    public TbUser save(TbUser entityVo) {
        return tbUserService.save(entityVo);
    }

    @GetMapping("delete/{id}")
    public Integer delete(@PathVariable("id") Integer id) {
        return tbUserService.delete(id);
    }
}