package com.lidaxia.springbootsecurity.controller;

import com.lidaxia.springbootsecurity.common.CommonController;
import com.lidaxia.springbootsecurity.pojo.SysAuthority;
import com.lidaxia.springbootsecurity.service.SysAuthorityService;
import com.lidaxia.springbootsecurity.vo.SysAuthorityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 9:37（
 */
@RestController
@RequestMapping("/sysAuthority/")
public class SysAuthorityController extends CommonController<SysAuthorityVo, SysAuthority, String> {
    @Autowired
    private SysAuthorityService sysAuthorityService;
}
