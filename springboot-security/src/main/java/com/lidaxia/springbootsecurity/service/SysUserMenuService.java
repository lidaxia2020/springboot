package com.lidaxia.springbootsecurity.service;

import com.lidaxia.common.restResult.RestResult;
import com.lidaxia.springbootsecurity.common.CommonService;
import com.lidaxia.springbootsecurity.pojo.SysUserMenu;
import com.lidaxia.springbootsecurity.vo.SysUserMenuVo;

import java.util.List;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 11:32（
 */
public interface SysUserMenuService extends CommonService<SysUserMenuVo, SysUserMenu, String> {
    RestResult<List<SysUserMenuVo>> findByUserId(String userId);
}