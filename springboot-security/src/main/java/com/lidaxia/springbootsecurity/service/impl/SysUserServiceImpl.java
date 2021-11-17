package com.lidaxia.springbootsecurity.service.impl;

import com.lidaxia.common.restResult.RestResult;
import com.lidaxia.common.restResult.ResultGenerator;
import com.lidaxia.common.utils.CopyUtil;
import com.lidaxia.springbootsecurity.common.CommonServiceImpl;
import com.lidaxia.springbootsecurity.pojo.SysUser;
import com.lidaxia.springbootsecurity.repository.SysUserRepository;
import com.lidaxia.springbootsecurity.service.SysUserService;
import com.lidaxia.springbootsecurity.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 11:26（
 */
@Service
@Transactional
public class SysUserServiceImpl extends CommonServiceImpl<SysUserVo, SysUser, String> implements SysUserService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public RestResult<SysUserVo> findByLoginName(String username) {
        return ResultGenerator.genSuccessResult(CopyUtil.copy(sysUserRepository.findByLoginName(username),SysUserVo.class));
    }
}