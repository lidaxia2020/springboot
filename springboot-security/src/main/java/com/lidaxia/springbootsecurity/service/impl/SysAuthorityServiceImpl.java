package com.lidaxia.springbootsecurity.service.impl;

import com.lidaxia.springbootsecurity.common.CommonServiceImpl;
import com.lidaxia.springbootsecurity.pojo.SysAuthority;
import com.lidaxia.springbootsecurity.repository.SysAuthorityRepository;
import com.lidaxia.springbootsecurity.service.SysAuthorityService;
import com.lidaxia.springbootsecurity.vo.SysAuthorityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/17 9:33（
 */
@Service
@Transactional
public class SysAuthorityServiceImpl extends CommonServiceImpl<SysAuthorityVo, SysAuthority, String> implements SysAuthorityService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SysAuthorityRepository sysAuthorityRepository;
}