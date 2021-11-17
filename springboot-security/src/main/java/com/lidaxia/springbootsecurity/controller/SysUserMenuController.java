package com.lidaxia.springbootsecurity.controller;

import com.lidaxia.springbootsecurity.common.CommonController;
import com.lidaxia.springbootsecurity.pojo.SysUserMenu;
import com.lidaxia.springbootsecurity.service.SysUserMenuService;
import com.lidaxia.springbootsecurity.vo.SysUserMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 11:31（
 */
@RestController
@RequestMapping("/sysUserMenu/")
public class SysUserMenuController extends CommonController<SysUserMenuVo, SysUserMenu, String> {
    @Autowired
    private SysUserMenuService sysUserMenuService;
}
