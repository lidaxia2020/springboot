package com.lidaxia.springbootsecurity.service.impl;

import com.lidaxia.common.restResult.RestResult;
import com.lidaxia.common.restResult.ResultGenerator;
import com.lidaxia.common.utils.CopyUtil;
import com.lidaxia.springbootsecurity.common.CommonServiceImpl;
import com.lidaxia.springbootsecurity.pojo.SysUserMenu;
import com.lidaxia.springbootsecurity.repository.SysUserMenuRepository;
import com.lidaxia.springbootsecurity.service.SysUserMenuService;
import com.lidaxia.springbootsecurity.vo.SysUserMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 11:32（
 */
@Service
@Transactional
public class SysUserMenuServiceImpl extends CommonServiceImpl<SysUserMenuVo, SysUserMenu, String> implements SysUserMenuService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SysUserMenuRepository sysUserMenuRepository;

    @Override
    public RestResult<List<SysUserMenuVo>> findByUserId(String userId) {
        return ResultGenerator.genSuccessResult(CopyUtil.copyList(sysUserMenuRepository.findByUserId(userId), SysUserMenuVo.class));
    }
}