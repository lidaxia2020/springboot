package com.lidaxia.springbootsecurity.controller;

import com.lidaxia.springbootsecurity.common.CommonController;
import com.lidaxia.springbootsecurity.pojo.SysShortcutMenu;
import com.lidaxia.springbootsecurity.service.SysShortcutMenuService;
import com.lidaxia.springbootsecurity.vo.SysShortcutMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 9:52（
 */
@RestController
@RequestMapping("/sysShortcutMenu/")
public class SysShortcutMenuController extends CommonController<SysShortcutMenuVo, SysShortcutMenu, String> {
    @Autowired
    private SysShortcutMenuService sysShortcutMenuService;
}
