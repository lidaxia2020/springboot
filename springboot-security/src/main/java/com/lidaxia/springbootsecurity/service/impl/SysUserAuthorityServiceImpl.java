package com.lidaxia.springbootsecurity.service.impl;

import com.lidaxia.common.restResult.RestResult;
import com.lidaxia.common.restResult.ResultGenerator;
import com.lidaxia.common.utils.CopyUtil;
import com.lidaxia.springbootsecurity.common.CommonServiceImpl;
import com.lidaxia.springbootsecurity.pojo.SysUserAuthority;
import com.lidaxia.springbootsecurity.repository.SysUserAuthorityRepository;
import com.lidaxia.springbootsecurity.service.SysUserAuthorityService;
import com.lidaxia.springbootsecurity.vo.SysUserAuthorityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 11:30（
 */
@Service
@Transactional
public class SysUserAuthorityServiceImpl extends CommonServiceImpl<SysUserAuthorityVo, SysUserAuthority, String> implements SysUserAuthorityService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SysUserAuthorityRepository sysUserAuthorityRepository;

    @Override
    public RestResult<List<SysUserAuthorityVo>> findByUserId(String userId) {
        return ResultGenerator.genSuccessResult(CopyUtil.copyList(sysUserAuthorityRepository.findByUserId(userId), SysUserAuthorityVo.class));
    }
}