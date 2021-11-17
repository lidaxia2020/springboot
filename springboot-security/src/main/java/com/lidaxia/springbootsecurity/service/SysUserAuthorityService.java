package com.lidaxia.springbootsecurity.service;

import com.lidaxia.common.restResult.RestResult;
import com.lidaxia.springbootsecurity.common.CommonService;
import com.lidaxia.springbootsecurity.pojo.SysUserAuthority;
import com.lidaxia.springbootsecurity.vo.SysUserAuthorityVo;

import java.util.List;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 11:29（
 */
public interface SysUserAuthorityService extends CommonService<SysUserAuthorityVo, SysUserAuthority, String> {
    RestResult<List<SysUserAuthorityVo>> findByUserId(String userId);
}
