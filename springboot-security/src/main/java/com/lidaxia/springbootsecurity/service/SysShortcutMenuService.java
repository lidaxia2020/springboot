package com.lidaxia.springbootsecurity.service;

import com.lidaxia.common.restResult.RestResult;
import com.lidaxia.springbootsecurity.common.CommonService;
import com.lidaxia.springbootsecurity.pojo.SysShortcutMenu;
import com.lidaxia.springbootsecurity.vo.SysShortcutMenuVo;

import java.util.List;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 9:56（
 */
public interface SysShortcutMenuService extends CommonService<SysShortcutMenuVo, SysShortcutMenu, String> {
    RestResult<List<SysShortcutMenuVo>> findByUserId(String userId);
}
