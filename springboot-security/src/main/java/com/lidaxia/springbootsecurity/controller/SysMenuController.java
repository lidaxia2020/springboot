package com.lidaxia.springbootsecurity.controller;

import com.lidaxia.springbootsecurity.common.CommonController;
import com.lidaxia.springbootsecurity.pojo.SysMenu;
import com.lidaxia.springbootsecurity.service.SysMenuService;
import com.lidaxia.springbootsecurity.vo.SysMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 9:42（
 */
@RestController
@RequestMapping("/sysMenu/")
public class SysMenuController extends CommonController<SysMenuVo, SysMenu, String> {
    @Autowired
    private SysMenuService sysMenuService;
}