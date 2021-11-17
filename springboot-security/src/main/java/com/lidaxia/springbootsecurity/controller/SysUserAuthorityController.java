package com.lidaxia.springbootsecurity.controller;

import com.lidaxia.springbootsecurity.common.CommonController;
import com.lidaxia.springbootsecurity.pojo.SysUserAuthority;
import com.lidaxia.springbootsecurity.service.SysUserAuthorityService;
import com.lidaxia.springbootsecurity.vo.SysUserAuthorityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 11:27（
 */
@RestController
@RequestMapping("/sysUserAuthority/")
public class SysUserAuthorityController extends CommonController<SysUserAuthorityVo, SysUserAuthority, String> {
    @Autowired
    private SysUserAuthorityService sysUserAuthorityService;
}
