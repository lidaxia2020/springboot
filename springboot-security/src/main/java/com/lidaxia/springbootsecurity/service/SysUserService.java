package com.lidaxia.springbootsecurity.service;

import com.lidaxia.common.restResult.RestResult;
import com.lidaxia.springbootsecurity.common.CommonService;
import com.lidaxia.springbootsecurity.pojo.SysUser;
import com.lidaxia.springbootsecurity.vo.SysUserVo;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 11:20（
 */
public interface SysUserService extends CommonService<SysUserVo, SysUser, String> {
    RestResult<SysUserVo> findByLoginName(String username);
}